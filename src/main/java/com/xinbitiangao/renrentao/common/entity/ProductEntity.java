package com.xinbitiangao.renrentao.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 黄大胖子
 * 2018/5/22 11:51
 */
@Entity
@Data
@Table(name = "product")
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
@Accessors(chain = true) //链式写法

public class ProductEntity {
    @Id
    private String productId;
    private String productName;
    private String productImgAddress;
    private String productDetailsAddress;
    private String productCategory;
    private String productTaokeAddress;
    private BigDecimal productPrice;
    private int productSales;
    private double productRate;
    private BigDecimal productRbrokerage;
    private String productSellerWangwang;
    private String productSellerId;
    private String productSellerShopName;
    private String platform;
    private String discountCouponId;
    private int discountCouponGross;
    private int discountCouponResidue;
    private String discountCouponSum;
    private Date discountCouponStartTime;
    private Date discountCouponOverTime;
    private String discountCouponAddress;
    private String productDiscountCouponAddress;

}
