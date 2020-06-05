/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.paycore.entity;


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
 * 支付引擎订单表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:56
 */
@Entity
@Table(name = "pay_payengine_order")
@Getter
@Setter
public class PaycorepayPayengineOrder extends AbstractEntity {

    /**
     * 全站统一订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String gid;

    /**
     * 外部商户订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 支付订单号
     */
	@NotEmpty
	@Size(max = 32)
    private String bizOrderNo;

    /**
     * 接入商ID
     */
	@Size(max = 32)
    private String partnerId;

    /**
     * 交易类型
     */
	@Size(max = 32)
    private String tradeType;

    /**
     * 支付类型
     */
	@Size(max = 32)
    private String payType;

    /**
     * 账务订单号
     */
	@Size(max = 32)
    private String subOrderNo;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 实际到账金额
     */
    private Long amountIn;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 交易主体用户编码
     */
	@Size(max = 32)
    private String userNo;

    /**
     * 交易主体账户号
     */
	@Size(max = 32)
    private String accountNo;

    /**
     * 交易主体渠道账户号
     */
	@Size(max = 64)
    private String bankAccountNo;

    /**
     * 交易主体账户名称
     */
	@Size(max = 64)
    private String accountName;

    /**
     * 交易主体冻结/解冻类型
     */
	@Size(max = 32)
    private String freezeType;

    /**
     * 交易主体冻结/解冻金额
     */
    private Long freezeAmount;

    /**
     * 交易主题交易后余额
     */
    private Long balance;

    /**
     * 交易对象用户编码
     */
	@Size(max = 32)
    private String refUserNo;

    /**
     * 交易对象账户号
     */
	@Size(max = 32)
    private String refAccountNo;

    /**
     * 交易对象渠道账户号
     */
	@Size(max = 64)
    private String refBankAccountNo;

    /**
     * 交易对象账户名称
     */
	@Size(max = 64)
    private String refAccountName;

    /**
     * 交易对象冻结/解冻类型
     */
	@Size(max = 32)
    private String refFreezeType;

    /**
     * 交易对象冻结/解冻金额
     */
    private Long refFreezeAmount;

    /**
     * 交易对象交易后余额
     */
    private Long refBalance;

    /**
     * 批量操作订单号
     */
	@Size(max = 32)
    private String batchBizOrderNo;

    /**
     * 本地处理备注
     */
	@Size(max = 512)
    private String comments;

    /**
     * 外部透传备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * 通知其他系统状态
     */
	@Size(max = 32)
    private String notifyStatus;

    /**
     * 通知上层系统备注
     */
	@Size(max = 128)
    private String notifyMsg;

    /**
     * 渠道
     */
	@Size(max = 64)
    private String serviceBankType;

    /**
     * 原冻结外部商户订单号
     */
	@Size(max = 64)
    private String freezeOrigMerchOrderNo;

    /**
     * 转账类型
     */
	@Size(max = 32)
    private String transferType;

    /**
     * 扩展字段json
     */
	@Size(max = 1024)
    private String extContextJson;

    /**
     * IP字段
     */
	@Size(max = 32)
    private String ipAddress;

}
