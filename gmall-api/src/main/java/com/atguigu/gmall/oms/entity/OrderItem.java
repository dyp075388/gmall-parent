package com.atguigu.gmall.oms.entity;

import java.math.BigDecimal;
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
@TableName("oms_order_item")
@ApiModel(value="OrderItem对象", description="")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "id")
    @TableField("order_id")
    private Long orderId;

    @TableField("order_sn")
    private String orderSn;

    @TableField("product_id")
    private Long productId;

    @TableField("product_pic")
    private String productPic;

    @TableField("product_name")
    private String productName;

    @TableField("product_brand")
    private String productBrand;

    @TableField("product_sn")
    private String productSn;

    @TableField("product_price")
    private BigDecimal productPrice;

    @TableField("product_quantity")
    private Integer productQuantity;

    @ApiModelProperty(value = "sku")
    @TableField("product_sku_id")
    private Long productSkuId;

    @ApiModelProperty(value = "sku")
    @TableField("product_sku_code")
    private String productSkuCode;

    @ApiModelProperty(value = "id")
    @TableField("product_category_id")
    private Long productCategoryId;

    @TableField("sp1")
    private String sp1;

    @TableField("sp2")
    private String sp2;

    @TableField("sp3")
    private String sp3;

    @TableField("promotion_name")
    private String promotionName;

    @TableField("promotion_amount")
    private BigDecimal promotionAmount;

    @TableField("coupon_amount")
    private BigDecimal couponAmount;

    @TableField("integration_amount")
    private BigDecimal integrationAmount;

    @TableField("real_amount")
    private BigDecimal realAmount;

    @TableField("gift_integration")
    private Integer giftIntegration;

    @TableField("gift_growth")
    private Integer giftGrowth;

//    @ApiModelProperty(value = ":[{"key":"","value":""},{"key":"","value":"4G"}]")
    @TableField("product_attr")
    private String productAttr;


}
