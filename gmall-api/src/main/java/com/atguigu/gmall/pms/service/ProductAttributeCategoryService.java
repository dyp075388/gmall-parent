package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.entity.ProductAttributeCategory;
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
public interface ProductAttributeCategoryService extends IService<ProductAttributeCategory> {

    PageInfoVo roductAttributeCategoryPageInfo(Integer pageNum, Integer pageSize);
}
