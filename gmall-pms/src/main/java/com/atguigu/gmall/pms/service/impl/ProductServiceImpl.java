package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.constant.EsConstant;
import com.atguigu.gmall.pms.entity.*;
import com.atguigu.gmall.pms.mapper.*;
import com.atguigu.gmall.pms.service.ProductService;
import com.atguigu.gmall.to.es.EsProduct;
import com.atguigu.gmall.to.es.EsProductAttributeValue;
import com.atguigu.gmall.to.es.EsSkuProductInfo;
import com.atguigu.gmall.vo.PageInfoVo;
import com.atguigu.gmall.vo.product.PmsProductParam;
import com.atguigu.gmall.vo.product.PmsProductQueryParam;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.searchbox.client.JestClient;
import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-10
 */
@Slf4j
@Service
@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductAttributeValueMapper productAttributeValueMapper;

    @Autowired
    ProductFullReductionMapper productFullReductionMapper;

    @Autowired
    ProductLadderMapper productLadderMapper;

    @Autowired
    SkuStockMapper skuStockMapper;

    @Autowired
    JestClient jestClient;

//    @Autowired
//    ProductService productService;

    //当前线程共享同样的数据
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    //ThreadLocal的原理
    private Map<Thread,Long> map = new HashMap<>();

    @Override
    public PageInfoVo productPageInfo(PmsProductQueryParam param) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();

        if(param.getBrandId() != null){
            wrapper.eq("brand_id",param.getBrandId());
        }

        if(!StringUtils.isEmpty(param.getKeyword())){
            wrapper.like("name",param.getKeyword());
        }

        if(param.getProductCategoryId()!=null){
            wrapper.eq("product_category_id",param.getProductCategoryId());
        }

        if(!StringUtils.isEmpty(param.getProductSn())){
            wrapper.like("product_sn",param.getProductSn());
        }

        if(param.getPublishStatus()!=null){
            wrapper.eq("publish_status",param.getPublishStatus());
        }

        if(param.getVerifyStatus()!=null){
            wrapper.eq("verify_status",param.getVerifyStatus());
        }

        IPage<Product> page = productMapper.selectPage(new Page<Product>(param.getPageNum(), param.getPageSize()), wrapper);

        PageInfoVo pageInfoVo = new PageInfoVo(page.getTotal(), page.getPages(), param.getPageSize(),
                page.getRecords(), page.getCurrent());

        return pageInfoVo;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveProduct(PmsProductParam productParam) {
        ProductServiceImpl proxy = (ProductServiceImpl) AopContext.currentProxy();
        //1）、pms_product：保存商品基本信息
        proxy.saveBaseInfo(productParam);

        //5）、pms_sku_stock：sku_库存表
        proxy.saveSkuStock(productParam);

        /**
         * 以下都可以try-catch互不影响
         */
        //2）、pms_product_attribute_value：保存这个商品对应的所有属性的值
        proxy.saveProductAttributeValue(productParam);

        //3）、pms_product_full_reduction：保存商品的满减信息
        proxy.saveFullReduction(productParam);

        //4）、pms_product_ladder：满减表
        proxy.saveProductLadder(productParam);

        //以上的写法只是相当于一个saveProduct事务。

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveSkuStock(PmsProductParam productParam) {
        List<SkuStock> skuStockList = productParam.getSkuStockList();
        for (int i = 1; i<=skuStockList.size(); i++) {
            SkuStock skuStock = skuStockList.get(i-1);
            if(StringUtils.isEmpty(skuStock.getSkuCode())){
                //skuCode必须有  1_1  1_2 1_3 1_4
                //生成规则  商品id_sku自增id
                skuStock.setSkuCode(threadLocal.get()+"_"+i);
            }
            skuStock.setProductId(threadLocal.get());
            skuStockMapper.insert(skuStock);
        }

        log.debug("当前线程....{}-->{}",Thread.currentThread().getId(),Thread.currentThread().getName());
    }

    /**
     * 默认出任何都回滚？
     *
     * @param productParam
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = FileNotFoundException.class,
            noRollbackFor = {ArithmeticException.class,NullPointerException.class})
    public void saveProductLadder(PmsProductParam productParam) {
        List<ProductLadder> productLadderList = productParam.getProductLadderList();
        productLadderList.forEach((productLadder)->{
            productLadder.setProductId(threadLocal.get());
            productLadderMapper.insert(productLadder);

        });

        log.debug("当前线程....{}-->{}",Thread.currentThread().getId(),Thread.currentThread().getName());
//        int i = 10/0;
//        File xxxx = new File("xxxx");
//        new FileInputStream(xxxx);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = {Exception.class})
    public void saveFullReduction(PmsProductParam productParam) {
        List<ProductFullReduction> fullReductionList = productParam.getProductFullReductionList();
        fullReductionList.forEach((reduction)->{
            reduction.setProductId(threadLocal.get());
            productFullReductionMapper.insert(reduction);
        });

        log.debug("当前线程....{}-->{}",Thread.currentThread().getId(),Thread.currentThread().getName());
    }

    /**
     * 保存商品基础信息
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveBaseInfo(PmsProductParam productParam){
        //1）、pms_product：保存商品基本信息
        Product product = new Product();
        BeanUtils.copyProperties(productParam,product);
        productMapper.insert(product);
        //mybatis-plus能自动获取到刚才这个数据的自增id
        log.debug("刚才的商品的id：{}",product.getId());
        threadLocal.set(product.getId());

        log.debug("当前线程....{}-->{}",Thread.currentThread().getId(),Thread.currentThread().getName());

    }
    //2）、pms_product_attribute_value：保存这个商品对应的所有属性的值
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductAttributeValue(PmsProductParam productParam){
        List<ProductAttributeValue> valueList = productParam.getProductAttributeValueList();
        valueList.forEach((item)->{
            item.setProductId(threadLocal.get());
            productAttributeValueMapper.insert(item);

        });

        log.debug("当前线程....{}-->{}",Thread.currentThread().getId(),Thread.currentThread().getName());
    }

    /**
     * CudSerivce：增删改service
     * RService：读service
     *
     *1）、dubbo的默认集群容错哪几种，怎么做？
     * failover/failfast/failsafe/failback/forking；
     * @Service注解上一配置就行。
     *
     *
     *
     * 改掉默认的mapping信息；
     * 1）、改掉不分词的字段
     * 2）、
     *
     *
     *
     * @param ids
     * @param publishStatus
     */
    @Override
    public void updatePublishStatus(List<Long> ids, Integer publishStatus) {
        if(publishStatus == 0){
            ids.forEach((id)->{
                //下架
                //改数据库状态
                setProductPublishStatus(publishStatus, id);
                //删es
                deleteProductFromEs(id);
            });

        }else {
            //上架
            ids.forEach((id)->{
                //该数据状态
                setProductPublishStatus(publishStatus, id);
                //加es
                saveProductToEs(id);
            });
        }
    }

    private void deleteProductFromEs(Long id) {

        Delete delete = new Delete.Builder(id.toString()).index(EsConstant.PRODUCT_ES_INDEX)
                .type(EsConstant.PRODUCT_INFO_ES_TYPE)
                .build();
        try {
            DocumentResult execute = jestClient.execute(delete);
            if(execute.isSucceeded()){
                log.info("商品：{} ==》ES下架完成",id);
            }else {
                //deleteProductFromEs(id);
                log.error("商品：{} ==》ES下架失败",id);
            }
        }catch (Exception e){
            //deleteProductFromEs(id);
            log.error("商品：{} ==》ES下架失败",id);
        }

    }

    /**
     * 给数据库插入数据
     * 1）、dubbo远程调用插入数据服务，可能经常超时。dubbo默认会重试
     * 导致这个方法会被调用多次。可能导致数据库同样的数据有多个。
     *
     * 2）、dubbo有自己默认的集群容错。
     *
     * 给数据库做数据的，最好用dubbo的快速失败模式。我们手工重试
     *
     * @param id
     */
    private void saveProductToEs(Long id) {
        //1、查出商品的基本信息
        Product productInfo = productInfo(id);
        EsProduct esProduct = new EsProduct();


        //1、复制基本信息
        BeanUtils.copyProperties(productInfo,esProduct);


        //2、复制sku信息，对于es要保存商品信息,还要查出这个商品的sku，给es中保存
        List<SkuStock> stocks = skuStockMapper.selectList(new QueryWrapper<SkuStock>().eq("product_id", id));
        List<EsSkuProductInfo> esSkuProductInfos = new ArrayList<>(stocks.size());


        //查出当前商品的sku属性  颜色  尺码
        List<ProductAttribute>  skuAttributeNames = productAttributeValueMapper.selectProductSaleAttrName(id);
        stocks.forEach((skuStock)->{
            EsSkuProductInfo info = new EsSkuProductInfo();
            BeanUtils.copyProperties(skuStock,info);

            //闪亮 黑色
            String subTitle = esProduct.getName();
            if(!StringUtils.isEmpty(skuStock.getSp1())){
                subTitle+=" "+skuStock.getSp1();
            }
            if(!StringUtils.isEmpty(skuStock.getSp2())){
                subTitle+=" "+skuStock.getSp2();
            }
            if(!StringUtils.isEmpty(skuStock.getSp3())){
                subTitle+=" "+skuStock.getSp3();
            }
            //sku的特色标题
            info.setSkuTitle(subTitle);
            List<EsProductAttributeValue> skuAttributeValues = new ArrayList<>();

            for (int i=0;i<skuAttributeNames.size();i++){
                //skuAttr 颜色/尺码
                EsProductAttributeValue value = new EsProductAttributeValue();

                value.setName(skuAttributeNames.get(i).getName());
                value.setProductId(id);
                value.setProductAttributeId(skuAttributeNames.get(i).getId());
                value.setType(skuAttributeNames.get(i).getType());

                //颜色   尺码;让es去统计‘；改掉查询商品的属性分类里面所有属性的时候，按照sort字段排序好
                if(i==0){
                    value.setValue(skuStock.getSp1());
                }
                if(i==1){
                    value.setValue(skuStock.getSp2());
                }
                if(i==2){
                    value.setValue(skuStock.getSp3());
                }

                skuAttributeValues.add(value);

            }


            info.setAttributeValues(skuAttributeValues);
            //sku有多个销售属性；颜色，尺码
            esSkuProductInfos.add(info);
            //查出销售属性的名

        });

        esProduct.setSkuProductInfos(esSkuProductInfos);


        List<EsProductAttributeValue> attributeValues = productAttributeValueMapper.selectProductBaseAttrAndValue(id);
        //3、复制公共属性信息，查出这个商品的公共属性
        esProduct.setAttrValueList(attributeValues);

        try {
            //把商品保存到es中
            Index build = new Index.Builder(esProduct)
                    .index(EsConstant.PRODUCT_ES_INDEX)
                    .type(EsConstant.PRODUCT_INFO_ES_TYPE)
                    .id(id.toString())
                    .build();
            DocumentResult execute = jestClient.execute(build);
            boolean succeeded = execute.isSucceeded();
            if(succeeded){
                log.info("ES中；id为{}商品上架完成",id);
            }else {
                log.error("ES中；id为{}商品未保存成功，开始重试",id);
                //saveProductToEs(id);
            }
        }catch (Exception e){
            log.error("ES中；id为{}商品数据保存异常；{}",id,e.getMessage());
            //saveProductToEs(id);
        }

    }

    public void setProductPublishStatus(Integer publishStatus, Long id) {
        //javaBean应该都去用包装类型
        Product product = new Product();
        //默认所有属性为null
        product.setId(id);
        product.setPublishStatus(publishStatus);
        //mybatis-plus自带的更新方法是哪个字段有值就更哪个字段
        productMapper.updateById(product);
    }

    @Override
    public Product productInfo(Long id) {
        return productMapper.selectById(id);
    }
}
