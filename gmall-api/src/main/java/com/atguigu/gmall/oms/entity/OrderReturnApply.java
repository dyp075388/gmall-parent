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
@TableName("oms_order_return_apply")
@ApiModel(value="OrderReturnApply对象", description="")
public class OrderReturnApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "id")
    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty(value = "id")
    @TableField("company_address_id")
    private Long companyAddressId;

    @ApiModelProperty(value = "id")
    @TableField("product_id")
    private Long productId;

    @TableField("order_sn")
    private String orderSn;

    @TableField("create_time")
    private Date createTime;

    @TableField("member_username")
    private String memberUsername;

    @TableField("return_amount")
    private BigDecimal returnAmount;

    @TableField("return_name")
    private String returnName;

    @TableField("return_phone")
    private String returnPhone;

    @ApiModelProperty(value = "0->1->2->3->")
    @TableField("status")
    private Integer status;

    @TableField("handle_time")
    private Date handleTime;

    @TableField("product_pic")
    private String productPic;

    @TableField("product_name")
    private String productName;

    @TableField("product_brand")
    private String productBrand;

    @ApiModelProperty(value = "xl;")
    @TableField("product_attr")
    private String productAttr;

    @TableField("product_count")
    private Integer productCount;

    @TableField("product_price")
    private BigDecimal productPrice;

    @TableField("product_real_price")
    private BigDecimal productRealPrice;

    @TableField("reason")
    private String reason;

    @TableField("description")
    private String description;

    @TableField("proof_pics")
    private String proofPics;

    @TableField("handle_note")
    private String handleNote;

    @TableField("handle_man")
    private String handleMan;

    @TableField("receive_man")
    private String receiveMan;

    @TableField("receive_time")
    private Date receiveTime;

    @TableField("receive_note")
    private String receiveNote;


}
