package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.entity.Brand;
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
public interface BrandService extends IService<Brand> {

    PageInfoVo brandPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
