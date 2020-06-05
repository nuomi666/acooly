/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.trade.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * 交易商品信息 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:34
 */
@Entity
@Table(name = "tra_trade_ext_goods")
@Getter
@Setter
public class TradetraTradeExtGoods extends AbstractEntity {

    /**
     * 商户订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String merchOrderNo;

    /**
     *  支付交易号
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeNo;

    /**
     * 商品的外部ID
     */
	@Size(max = 64)
    private String outId;

    /**
     * 商品名称
     */
	@Size(max = 128)
    private String name;

    /**
     * 商品详情
     */
	@Size(max = 128)
    private String detail;

    /**
     * 商品单价
     */
    private Long price;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品其它费用
     */
    private Long otherFee;

    /**
     * 商品单位
     */
	@Size(max = 32)
    private String unit;

    /**
     * 商品描述网址
     */
	@Size(max = 512)
    private String detailUrl;

    /**
     * 商品来源网址
     */
	@Size(max = 512)
    private String referUrl;

    /**
     * 商品类目
     */
	@Size(max = 64)
    private String category;

    /**
     * gid
     */
	@Size(max = 64)
    private String gid;

    /**
     * 所属商户
     */
	@Size(max = 64)
    private String partnerId;

}
