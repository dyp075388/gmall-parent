package com.atguigu.gmall.ums.entity;

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
@TableName("ums_growth_change_history")
@ApiModel(value="GrowthChangeHistory对象", description="")
public class GrowthChangeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("member_id")
    private Long memberId;

    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "0->1->")
    @TableField("change_type")
    private Integer changeType;

    @TableField("change_count")
    private Integer changeCount;

    @TableField("operate_man")
    private String operateMan;

    @TableField("operate_note")
    private String operateNote;

    @ApiModelProperty(value = "0->1->")
    @TableField("source_type")
    private Integer sourceType;


}
