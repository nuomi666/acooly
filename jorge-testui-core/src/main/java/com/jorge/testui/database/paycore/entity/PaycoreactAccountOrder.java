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
 * 账务系统订单表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:55
 */
@Entity
@Table(name = "act_account_order")
@Getter
@Setter
public class PaycoreactAccountOrder extends AbstractEntity {

    /**
     * 全站统一订单号
     */
	@Size(max = 64)
    private String gid;

    /**
     * 外部商户订单号
     */
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
     * 操作类型
     */
	@Size(max = 32)
    private String orderType;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 外部透传备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * 批量操作订单号
     */
	@Size(max = 32)
    private String batchBizOrderNo;

    /**
     * 扩展字段json
     */
	@Size(max = 1024)
    private String extContextJson;

    /**
     * 用户编码
     */
	@Size(max = 32)
    private String userNo;

    /**
     * 账户号
     */
	@Size(max = 32)
    private String accountNo;

    /**
     * 相关用户编码
     */
	@Size(max = 32)
    private String refUserNo;

    /**
     * 相关用户账户号
     */
	@Size(max = 32)
    private String refAccountNo;

    /**
     * 备注
     */
	@Size(max = 512)
    private String comments;

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
     * 金额
     */
    private Long amount;

    /**
     * 网关时间
     */
    private Date gatewayTime;

}
