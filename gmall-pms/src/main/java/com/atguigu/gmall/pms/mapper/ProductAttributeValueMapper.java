package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.ProductAttribute;
import com.atguigu.gmall.pms.entity.ProductAttributeValue;
import com.atguigu.gmall.to.es.EsProductAttributeValue;
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
public interface ProductAttributeValueMapper extends BaseMapper<ProductAttributeValue> {

    List<ProductAttribute> selectProductSaleAttrName(Long id);

    List<EsProductAttributeValue> selectProductBaseAttrAndValue(Long id);
}
