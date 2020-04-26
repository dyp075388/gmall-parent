package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.entity.ProductAttribute;
import com.atguigu.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-10
 */
public interface ProductAttributeService extends IService<ProductAttribute> {

    PageInfoVo getCategoryAttributes(Long cid, Integer type, Integer pageSize, Integer pageNum);
}
