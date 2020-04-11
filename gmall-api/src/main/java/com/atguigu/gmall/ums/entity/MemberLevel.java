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
@TableName("ums_member_level")
@ApiModel(value="MemberLevel对象", description="")
public class MemberLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("growth_point")
    private Integer growthPoint;

    @ApiModelProperty(value = "0->1->")
    @TableField("default_status")
    private Integer defaultStatus;

    @TableField("free_freight_point")
    private BigDecimal freeFreightPoint;

    @TableField("comment_growth_point")
    private Integer commentGrowthPoint;

    @TableField("priviledge_free_freight")
    private Integer priviledgeFreeFreight;

    @TableField("priviledge_sign_in")
    private Integer priviledgeSignIn;

    @TableField("priviledge_comment")
    private Integer priviledgeComment;

    @TableField("priviledge_promotion")
    private Integer priviledgePromotion;

    @TableField("priviledge_member_price")
    private Integer priviledgeMemberPrice;

    @TableField("priviledge_birthday")
    private Integer priviledgeBirthday;

    @TableField("note")
    private String note;


}
