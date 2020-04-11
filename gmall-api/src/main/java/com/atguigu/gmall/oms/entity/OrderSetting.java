package com.atguigu.gmall.oms.entity;

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
@TableName("oms_order_setting")
@ApiModel(value="OrderSetting对象", description="")
public class OrderSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "()")
    @TableField("flash_order_overtime")
    private Integer flashOrderOvertime;

    @ApiModelProperty(value = "()")
    @TableField("normal_order_overtime")
    private Integer normalOrderOvertime;

    @TableField("confirm_overtime")
    private Integer confirmOvertime;

    @TableField("finish_overtime")
    private Integer finishOvertime;

    @TableField("comment_overtime")
    private Integer commentOvertime;


}
