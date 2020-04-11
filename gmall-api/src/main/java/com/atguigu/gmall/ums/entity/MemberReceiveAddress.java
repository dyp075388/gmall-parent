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
@TableName("ums_member_receive_address")
@ApiModel(value="MemberReceiveAddress对象", description="")
public class MemberReceiveAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("member_id")
    private Long memberId;

    @TableField("name")
    private String name;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("default_status")
    private Integer defaultStatus;

    @TableField("post_code")
    private String postCode;

    @ApiModelProperty(value = "/")
    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("region")
    private String region;

    @ApiModelProperty(value = "()")
    @TableField("detail_address")
    private String detailAddress;


}
