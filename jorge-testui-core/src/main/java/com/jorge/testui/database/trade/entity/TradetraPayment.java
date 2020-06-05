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
 * 通用交易支付 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:32
 */
@Entity
@Table(name = "tra_payment")
@Getter
@Setter
public class TradetraPayment extends AbstractEntity {

    /**
     * gid
     */
	@NotEmpty
	@Size(max = 64)
    private String gid;

    /**
     * 交易订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeNo;

    /**
     * 商户订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 银行订单号
     */
	@Size(max = 64)
    private String bankOrderNo;

    /**
     * 支付订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String payOrderNo;

    /**
     * 交易金额
     */
	@NotNull
    private Long amount;

    /**
     * 类型
     */
	@NotEmpty
	@Size(max = 32)
    private String type;

    /**
     * 状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * 付款人用户号
     */
	@Size(max = 64)
    private String payerUserNo;

    /**
     * 付款人账户
     */
	@Size(max = 64)
    private String payerAccountNo;

    /**
     * 收款人用户号
     */
	@Size(max = 64)
    private String payeeUserNo;

    /**
     * 收款人账户
     */
	@Size(max = 64)
    private String payeeAccountNo;

    /**
     * 真实收款用户号
     */
	@Size(max = 32)
    private String realPayeeUserNo;

    /**
     * 真实收款账户号
     */
	@Size(max = 32)
    private String realPayeeAccountNo;

    /**
     * 对账状态
     */
	@Size(max = 32)
    private String reconStatus;

    /**
     * 账期
     */
	@Size(max = 20)
    private String accountPeriod;

    /**
     * 交易备注
     */
	@Size(max = 512)
    private String tradeMemo;

    /**
     * 执行节点
     */
	@Size(max = 40)
    private String flowNode;

    /**
     * service_bank_mode
     */
	@Size(max = 32)
    private String serviceBankMode;

    /**
     * service_bank_type
     */
	@Size(max = 32)
    private String serviceBankType;

    /**
     * bank_fee
     */
    private Integer bankFee;

    /**
     * 所属商户
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * 账期
     */
	@Size(max = 32)
    private String accountPeriodNo;

    /**
     * sub_merch_order_no
     */
	@Size(max = 32)
    private String subMerchOrderNo;

}
