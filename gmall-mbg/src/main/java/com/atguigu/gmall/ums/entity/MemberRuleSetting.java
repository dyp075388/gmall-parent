package com.atguigu.gmall.ums.entity;

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
@TableName("ums_member_rule_setting")
@ApiModel(value="MemberRuleSetting对象", description="")
public class MemberRuleSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("continue_sign_day")
    private Integer continueSignDay;

    @TableField("continue_sign_point")
    private Integer continueSignPoint;

    @ApiModelProperty(value = "1")
    @TableField("consume_per_point")
    private BigDecimal consumePerPoint;

    @TableField("low_order_amount")
    private BigDecimal lowOrderAmount;

    @TableField("max_point_per_order")
    private Integer maxPointPerOrder;

    @ApiModelProperty(value = "0->1->")
    @TableField("type")
    private Integer type;


}
