package com.atguigu.gmall.sms.entity;

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
@TableName("sms_coupon_history")
@ApiModel(value="CouponHistory对象", description="")
public class CouponHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("coupon_id")
    private Long couponId;

    @TableField("member_id")
    private Long memberId;

    @TableField("coupon_code")
    private String couponCode;

    @TableField("member_nickname")
    private String memberNickname;

    @ApiModelProperty(value = "0->1->")
    @TableField("get_type")
    private Integer getType;

    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("use_status")
    private Integer useStatus;

    @TableField("use_time")
    private Date useTime;

    @TableField("order_id")
    private Long orderId;

    @TableField("order_sn")
    private String orderSn;


}
