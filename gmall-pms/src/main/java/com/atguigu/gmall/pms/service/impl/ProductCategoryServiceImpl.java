package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.entity.ProductCategory;
import com.atguigu.gmall.pms.mapper.ProductCategoryMapper;
import com.atguigu.gmall.pms.service.ProductCategoryService;
import com.atguigu.gmall.vo.product.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-10
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Override
    public List<PmsProductCategoryWithChildrenItem> listCatelogWithChilder(int i) {
        return null;
    }
}
