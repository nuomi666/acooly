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
 * 交易分润列表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:35
 */
@Entity
@Table(name = "tra_trade_profit_order")
@Getter
@Setter
public class TradetraTradeProfitOrder extends AbstractEntity {

    /**
     * gid
     */
	@NotEmpty
	@Size(max = 64)
    private String gid;

    /**
     * 商户订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 支付交易订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeNo;

    /**
     * 商户分润订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String profitMerchOrderNo;

    /**
     * 支付订单号
     */
	@Size(max = 64)
    private String payOrderNo;

    /**
     * 交易金额
     */
	@NotNull
    private Long amount;

    /**
     * 清分收费类型
     */
	@Size(max = 32)
    private String chargeType;

    /**
     * 状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * 付款人用户号
     */
	@Size(max = 255)
    private String payerUserNo;

    /**
     * 付款人账户
     */
	@Size(max = 255)
    private String payerAccountNo;

    /**
     * 收款人用户号
     */
	@Size(max = 255)
    private String payeeUserNo;

    /**
     * 收款人账户
     */
	@Size(max = 255)
    private String payeeAccountNo;

    /**
     * 清分类型
     */
	@Size(max = 64)
    private String profitType;

    /**
     * 交易备注
     */
	@Size(max = 512)
    private String tradeMemo;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * 所属商户
     */
	@Size(max = 32)
    private String partnerId;

}
