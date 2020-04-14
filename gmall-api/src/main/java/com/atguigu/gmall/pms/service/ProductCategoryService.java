package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.entity.ProductCategory;
import com.atguigu.gmall.vo.product.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-10
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    List<PmsProductCategoryWithChildrenItem> listCatelogWithChilder(int i);
}
