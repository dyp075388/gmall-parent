package com.atguigu.gmall.vo.product;


import com.atguigu.gmall.pms.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PmsProductCategoryWithChildrenItem extends ProductCategory  implements Serializable {



    private List<ProductCategory> children;

}
