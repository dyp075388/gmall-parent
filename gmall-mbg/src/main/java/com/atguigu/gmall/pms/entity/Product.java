package com.atguigu.gmall.pms.entity;

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
@TableName("pms_product")
@ApiModel(value="Product对象", description="")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("brand_id")
    private Long brandId;

    @TableField("product_category_id")
    private Long productCategoryId;

    @TableField("feight_template_id")
    private Long feightTemplateId;

    @TableField("product_attribute_category_id")
    private Long productAttributeCategoryId;

    @TableField("name")
    private String name;

    @TableField("pic")
    private String pic;

    @TableField("product_sn")
    private String productSn;

    @ApiModelProperty(value = "0->1->")
    @TableField("delete_status")
    private Integer deleteStatus;

    @ApiModelProperty(value = "0->1->")
    @TableField("publish_status")
    private Integer publishStatus;

    @ApiModelProperty(value = ":0->1->")
    @TableField("new_status")
    private Integer newStatus;

    @ApiModelProperty(value = "0->1->")
    @TableField("recommand_status")
    private Integer recommandStatus;

    @ApiModelProperty(value = "0->1->")
    @TableField("verify_status")
    private Integer verifyStatus;

    @TableField("sort")
    private Integer sort;

    @TableField("sale")
    private Integer sale;

    @TableField("price")
    private BigDecimal price;

    @TableField("promotion_price")
    private BigDecimal promotionPrice;

    @TableField("gift_growth")
    private Integer giftGrowth;

    @TableField("gift_point")
    private Integer giftPoint;

    @TableField("use_point_limit")
    private Integer usePointLimit;

    @TableField("sub_title")
    private String subTitle;

    @TableField("description")
    private String description;

    @TableField("original_price")
    private BigDecimal originalPrice;

    @TableField("stock")
    private Integer stock;

    @TableField("low_stock")
    private Integer lowStock;

    @TableField("unit")
    private String unit;

    @TableField("weight")
    private BigDecimal weight;

    @ApiModelProperty(value = "0->1->")
    @TableField("preview_status")
    private Integer previewStatus;

    @ApiModelProperty(value = "1->2->3->")
    @TableField("service_ids")
    private String serviceIds;

    @TableField("keywords")
    private String keywords;

    @TableField("note")
    private String note;

    @ApiModelProperty(value = "5")
    @TableField("album_pics")
    private String albumPics;

    @TableField("detail_title")
    private String detailTitle;

    @TableField("detail_desc")
    private String detailDesc;

    @TableField("detail_html")
    private String detailHtml;

    @TableField("detail_mobile_html")
    private String detailMobileHtml;

    @TableField("promotion_start_time")
    private Date promotionStartTime;

    @TableField("promotion_end_time")
    private Date promotionEndTime;

    @TableField("promotion_per_limit")
    private Integer promotionPerLimit;

    @ApiModelProperty(value = "0->;1->2->3->4->5->")
    @TableField("promotion_type")
    private Integer promotionType;

    @TableField("brand_name")
    private String brandName;

    @TableField("product_category_name")
    private String productCategoryName;


}
