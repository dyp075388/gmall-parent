package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.pms.entity.Brand;
import com.atguigu.gmall.pms.mapper.BrandMapper;
import com.atguigu.gmall.pms.service.BrandService;
import com.atguigu.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-10
 */
@Slf4j
@Component
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageInfoVo brandPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        //1.创建QueryMapper
        QueryWrapper<Brand> name = null;
        if(!StringUtils.isEmpty(keyword)){
            name = new QueryWrapper<Brand>().like("name", keyword);
        }

        //2.调用dao层的selectPage方法
        IPage<Brand> brandIPage = brandMapper.selectPage(new Page<Brand>(pageNum.longValue(), pageSize.longValue()), name);

        //3.返回前台的Vo对象
        PageInfoVo pageInfoVo = new PageInfoVo(brandIPage.getTotal(),
                brandIPage.getPages(), pageSize.longValue(), brandIPage.getRecords(),
                brandIPage.getCurrent());

        return pageInfoVo;
    }
}
