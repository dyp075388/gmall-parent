package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lfy
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pms_brand")
@ApiModel(value="Brand对象", description="")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("first_letter")
    private String firstLetter;

    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "0->1->")
    @TableField("factory_status")
    private Integer factoryStatus;

    @TableField("show_status")
    private Integer showStatus;

    @TableField("product_count")
    private Integer productCount;

    @TableField("product_comment_count")
    private Integer productCommentCount;

    @ApiModelProperty(value = "logo")
    @TableField("logo")
    private String logo;

    @TableField("big_pic")
    private String bigPic;

    @TableField("brand_story")
    private String brandStory;


}
