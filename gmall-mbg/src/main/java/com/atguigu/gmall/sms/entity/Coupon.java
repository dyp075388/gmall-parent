package com.atguigu.gmall.sms.entity;

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
@TableName("sms_coupon")
@ApiModel(value="Coupon对象", description="")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "0->1->2->3->")
    @TableField("type")
    private Integer type;

    @TableField("name")
    private String name;

    @ApiModelProperty(value = "0->1->2->PC")
    @TableField("platform")
    private Integer platform;

    @TableField("count")
    private Integer count;

    @TableField("amount")
    private BigDecimal amount;

    @TableField("per_limit")
    private Integer perLimit;

    @ApiModelProperty(value = "0")
    @TableField("min_point")
    private BigDecimal minPoint;

    @TableField("start_time")
    private Date startTime;

    @TableField("end_time")
    private Date endTime;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("use_type")
    private Integer useType;

    @TableField("note")
    private String note;

    @TableField("publish_count")
    private Integer publishCount;

    @TableField("use_count")
    private Integer useCount;

    @TableField("receive_count")
    private Integer receiveCount;

    @TableField("enable_time")
    private Date enableTime;

    @TableField("code")
    private String code;

    @ApiModelProperty(value = "0->")
    @TableField("member_level")
    private Integer memberLevel;


}
