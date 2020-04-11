package com.atguigu.gmall.ums.entity;

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
@TableName("ums_integration_consume_setting")
@ApiModel(value="IntegrationConsumeSetting对象", description="")
public class IntegrationConsumeSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("deduction_per_amount")
    private Integer deductionPerAmount;

    @TableField("max_percent_per_order")
    private Integer maxPercentPerOrder;

    @ApiModelProperty(value = "100")
    @TableField("use_unit")
    private Integer useUnit;

    @ApiModelProperty(value = "0->1->")
    @TableField("coupon_status")
    private Integer couponStatus;


}
