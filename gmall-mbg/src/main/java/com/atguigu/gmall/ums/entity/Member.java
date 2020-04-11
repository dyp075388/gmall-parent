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
@TableName("ums_member")
@ApiModel(value="Member对象", description="")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("member_level_id")
    private Long memberLevelId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("nickname")
    private String nickname;

    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = ":0->1->")
    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private Date createTime;

    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "0->1->2->")
    @TableField("gender")
    private Integer gender;

    @TableField("birthday")
    private Date birthday;

    @TableField("city")
    private String city;

    @TableField("job")
    private String job;

    @TableField("personalized_signature")
    private String personalizedSignature;

    @TableField("source_type")
    private Integer sourceType;

    @TableField("integration")
    private Integer integration;

    @TableField("growth")
    private Integer growth;

    @TableField("luckey_count")
    private Integer luckeyCount;

    @TableField("history_integration")
    private Integer historyIntegration;


}
