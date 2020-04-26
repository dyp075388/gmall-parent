package com.atguigu.gmall.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.search.SearchProductService;
import com.atguigu.gmall.vo.search.SearchParam;
import com.atguigu.gmall.vo.search.SearchResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductSearchController
 * @Description 商品检索的controller
 * @Author 张燕廷
 * @Date 2020/4/26 11:40
 * @Version 1.0
 **/
@Api(tags = "检索功能")
@RestController
public class ProductSearchController {

    @Reference
    SearchProductService searchProductService;

    /**
     * @Author 张燕廷
     * @Description 检索商品
     * @Date 14:06 2020/4/26
     * @Param [searchParam]
     * @return com.atguigu.gmall.vo.search.SearchResponse
     **/
    @ApiOperation("商品检索")
    @GetMapping("/search")
    public SearchResponse productSearchResponse(SearchParam searchParam){

        SearchResponse searchResponse = searchProductService.searchProduct(searchParam);

        return searchResponse;
    }

}
