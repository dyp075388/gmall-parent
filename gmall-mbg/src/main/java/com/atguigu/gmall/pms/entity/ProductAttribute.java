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
@TableName("pms_product_attribute")
@ApiModel(value="ProductAttribute对象", description="")
public class ProductAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("product_attribute_category_id")
    private Long productAttributeCategoryId;

    @TableField("name")
    private String name;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("select_type")
    private Integer selectType;

    @ApiModelProperty(value = "0->1->")
    @TableField("input_type")
    private Integer inputType;

    @TableField("input_list")
    private String inputList;

    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "1->1->")
    @TableField("filter_type")
    private Integer filterType;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("search_type")
    private Integer searchType;

    @ApiModelProperty(value = "0->1->")
    @TableField("related_status")
    private Integer relatedStatus;

    @ApiModelProperty(value = "0->1->")
    @TableField("hand_add_status")
    private Integer handAddStatus;

    @ApiModelProperty(value = "0->1->")
    @TableField("type")
    private Integer type;


}
