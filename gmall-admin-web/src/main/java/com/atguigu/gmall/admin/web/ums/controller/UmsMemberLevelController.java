package com.atguigu.gmall.admin.web.ums.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.to.CommonResult;
import com.atguigu.gmall.ums.entity.MemberLevel;
import com.atguigu.gmall.ums.service.MemberLevelService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@Api(tags = "UmsMemberLevelController", description = "会员等级管理")
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {


    @Reference
    MemberLevelService memberLevelService;
    /**
     * 查出所有会员等级
     * @return
     */
    @GetMapping("/list")
    public CommonResult memberLevelList(){
        List<MemberLevel> list = memberLevelService.list();
        return new CommonResult().success(list);
    }
}
