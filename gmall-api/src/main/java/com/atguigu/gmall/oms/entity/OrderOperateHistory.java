package com.atguigu.gmall.oms.entity;

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
@TableName("oms_order_operate_history")
@ApiModel(value="OrderOperateHistory对象", description="")
public class OrderOperateHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "id")
    @TableField("order_id")
    private Long orderId;

    @TableField("operate_man")
    private String operateMan;

    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "0->1->2->3->4->5->")
    @TableField("order_status")
    private Integer orderStatus;

    @TableField("note")
    private String note;


}
