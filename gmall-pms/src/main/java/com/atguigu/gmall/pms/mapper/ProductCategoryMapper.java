package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.ProductCategory;
import com.atguigu.gmall.vo.product.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-04-10
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    List<PmsProductCategoryWithChildrenItem> listCatelogWithChildren(int i);
}
