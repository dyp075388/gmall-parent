package com.atguigu.gmall.vo.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PmsBrandParam
 * @Description 品牌传递参数
 * @Author 张燕廷
 * @Date 2020/4/14 9:51
 * @Version 1.0
 **/
@Data
public class PmsBrandParam  implements Serializable {
    @ApiModelProperty(value = "品牌名称",required = true)

    private String name;
    @ApiModelProperty(value = "品牌首字母")
    private String firstLetter;
    @ApiModelProperty(value = "排序字段")

    private Integer sort;
    @ApiModelProperty(value = "是否为厂家制造商")
    private Integer factoryStatus;
    @ApiModelProperty(value = "是否进行显示")
    private Integer showStatus;
    @ApiModelProperty(value = "品牌logo",required = true)

    private String logo;
    @ApiModelProperty(value = "品牌大图")
    private String bigPic;
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;


}
