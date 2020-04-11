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
@TableName("oms_order")
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("member_id")
    private Long memberId;

    @TableField("coupon_id")
    private Long couponId;

    @TableField("order_sn")
    private String orderSn;

    @TableField("create_time")
    private Date createTime;

    @TableField("member_username")
    private String memberUsername;

    @TableField("total_amount")
    private BigDecimal totalAmount;

    @TableField("pay_amount")
    private BigDecimal payAmount;

    @TableField("freight_amount")
    private BigDecimal freightAmount;

    @TableField("promotion_amount")
    private BigDecimal promotionAmount;

    @TableField("integration_amount")
    private BigDecimal integrationAmount;

    @TableField("coupon_amount")
    private BigDecimal couponAmount;

    @TableField("discount_amount")
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("pay_type")
    private Integer payType;

    @ApiModelProperty(value = "0->PC1->app")
    @TableField("source_type")
    private Integer sourceType;

    @ApiModelProperty(value = "0->1->2->3->4->5->")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "0->1->")
    @TableField("order_type")
    private Integer orderType;

    @ApiModelProperty(value = "()")
    @TableField("delivery_company")
    private String deliveryCompany;

    @TableField("delivery_sn")
    private String deliverySn;

    @TableField("auto_confirm_day")
    private Integer autoConfirmDay;

    @TableField("integration")
    private Integer integration;

    @TableField("growth")
    private Integer growth;

    @TableField("promotion_info")
    private String promotionInfo;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("bill_type")
    private Integer billType;

    @TableField("bill_header")
    private String billHeader;

    @TableField("bill_content")
    private String billContent;

    @TableField("bill_receiver_phone")
    private String billReceiverPhone;

    @TableField("bill_receiver_email")
    private String billReceiverEmail;

    @TableField("receiver_name")
    private String receiverName;

    @TableField("receiver_phone")
    private String receiverPhone;

    @TableField("receiver_post_code")
    private String receiverPostCode;

    @ApiModelProperty(value = "/")
    @TableField("receiver_province")
    private String receiverProvince;

    @TableField("receiver_city")
    private String receiverCity;

    @TableField("receiver_region")
    private String receiverRegion;

    @TableField("receiver_detail_address")
    private String receiverDetailAddress;

    @TableField("note")
    private String note;

    @ApiModelProperty(value = "0->1->")
    @TableField("confirm_status")
    private Integer confirmStatus;

    @ApiModelProperty(value = "0->1->")
    @TableField("delete_status")
    private Integer deleteStatus;

    @TableField("use_integration")
    private Integer useIntegration;

    @TableField("payment_time")
    private Date paymentTime;

    @TableField("delivery_time")
    private Date deliveryTime;

    @TableField("receive_time")
    private Date receiveTime;

    @TableField("comment_time")
    private Date commentTime;

    @TableField("modify_time")
    private Date modifyTime;


}
