/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-02-19
*/
package com.jorge.testui.database.bill.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 交易分润列表 Entity
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
@Entity
@Table(name = "tra_trade_profit")
@Getter
@Setter
public class TraTradeProfit extends AbstractEntity {

    /**
     * gid
     */
	@NotEmpty
	@Size(max = 64)
    private String gid;

    /**
     * 支付商户订单号
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
     * 状态
     */
	@Size(max = 32)
    private String status;

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

    /**
     * charge_type
     */
	@Size(max = 255)
    private String chargeType;

    /**
     * 交易名称
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeName;

    /**
     * 分润金额
     */
	@NotNull
    private Long profitAmount;

    /**
     * 付款方会员id
     */
	@Size(max = 32)
    private String payerUserNo;

    /**
     * 付款方账户id
     */
	@Size(max = 32)
    private String payerAccountNo;

    /**
     * 收款方会员id
     */
	@Size(max = 32)
    private String payeeUserNo;

    /**
     * 收款方账户id
     */
	@Size(max = 32)
    private String payeeAccountNo;

    /**
     * 交易手续费
     */
    private Long clearAmount;

    /**
     * 付款类型
     */
	@Size(max = 64)
    private String type;

    /**
     * 账期
     */
	@Size(max = 12)
    private String periodNo;

}
