package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.constant.SysCacheConstant;
import com.atguigu.gmall.pms.entity.ProductCategory;
import com.atguigu.gmall.pms.mapper.ProductCategoryMapper;
import com.atguigu.gmall.pms.service.ProductCategoryService;
import com.atguigu.gmall.vo.product.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

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
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Override
    public List<PmsProductCategoryWithChildrenItem> listCatelogWithChilder(int i) {
        Object cacheMenu = redisTemplate.opsForValue().get(SysCacheConstant.CATEGORY_MENU_CACHE_KEY);
        List<PmsProductCategoryWithChildrenItem> items;
        if(cacheMenu!=null){
            //缓存中有
            log.debug("菜单数据命中缓存......");
            items = (List<PmsProductCategoryWithChildrenItem>) cacheMenu;
        }else {
            items  = productCategoryMapper.listCatelogWithChildren(i);
            redisTemplate.opsForValue().set(SysCacheConstant.CATEGORY_MENU_CACHE_KEY,items);
        }
        log.info(items.toString());
        log.info(new PmsProductCategoryWithChildrenItem().toString());
        return items;
    }
}
