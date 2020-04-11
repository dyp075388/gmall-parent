package com.atguigu.gmall.oms.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@TableName("oms_cart_item")
@ApiModel(value="CartItem对象", description="")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("product_id")
    private Long productId;

    @TableField("product_sku_id")
    private Long productSkuId;

    @TableField("member_id")
    private Long memberId;

    @TableField("quantity")
    private Integer quantity;

    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "1")
    @TableField("sp1")
    private String sp1;

    @ApiModelProperty(value = "2")
    @TableField("sp2")
    private String sp2;

    @ApiModelProperty(value = "3")
    @TableField("sp3")
    private String sp3;

    @TableField("product_pic")
    private String productPic;

    @TableField("product_name")
    private String productName;

    @TableField("product_sub_title")
    private String productSubTitle;

    @ApiModelProperty(value = "sku")
    @TableField("product_sku_code")
    private String productSkuCode;

    @TableField("member_nickname")
    private String memberNickname;

    @TableField("create_date")
    private Date createDate;

    @TableField("modify_date")
    private Date modifyDate;

    @TableField("delete_status")
    private Integer deleteStatus;

    @TableField("product_category_id")
    private Long productCategoryId;

    @TableField("product_brand")
    private String productBrand;

    @TableField("product_sn")
    private String productSn;

//    @ApiModelProperty(value = ":[{"key":"","value":""},{"key":"","value":"4G"}]")
    @TableField("product_attr")
    private String productAttr;


}
