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
@TableName("oms_company_address")
@ApiModel(value="CompanyAddress对象", description="")
public class CompanyAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("address_name")
    private String addressName;

    @ApiModelProperty(value = "0->1->")
    @TableField("send_status")
    private Integer sendStatus;

    @ApiModelProperty(value = "0->1->")
    @TableField("receive_status")
    private Integer receiveStatus;

    @TableField("name")
    private String name;

    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "/")
    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("region")
    private String region;

    @TableField("detail_address")
    private String detailAddress;


}
