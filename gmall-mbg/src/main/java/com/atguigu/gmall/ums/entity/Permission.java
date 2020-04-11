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
@TableName("ums_permission")
@ApiModel(value="Permission对象", description="")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "id")
    @TableField("pid")
    private Long pid;

    @TableField("name")
    private String name;

    @TableField("value")
    private String value;

    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("type")
    private Integer type;

    @TableField("uri")
    private String uri;

    @ApiModelProperty(value = "0->1->")
    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private Date createTime;

    @TableField("sort")
    private Integer sort;


}
