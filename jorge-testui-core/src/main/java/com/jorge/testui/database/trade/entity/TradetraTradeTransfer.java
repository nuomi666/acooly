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
 * 交易转账记录 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:35
 */
@Entity
@Table(name = "tra_trade_transfer")
@Getter
@Setter
public class TradetraTradeTransfer extends AbstractEntity {

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
     * 状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * 类型
     */
	@Size(max = 32)
    private String type;

    /**
     * 付款人用户号
     */
	@Size(max = 64)
    private String payerUserNo;

    /**
     * 付款人用户名
     */
	@Size(max = 64)
    private String payerUserName;

    /**
     * 付款人账户
     */
	@Size(max = 64)
    private String payerAccountNo;

    /**
     * 付款人真实姓名
     */
	@Size(max = 64)
    private String payerRealName;

    /**
     * 收款人用户号
     */
	@Size(max = 64)
    private String payeeUserNo;

    /**
     * 收款人用户名
     */
	@Size(max = 64)
    private String payeeUserName;

    /**
     * 收款人账户
     */
	@Size(max = 64)
    private String payeeAccountNo;

    /**
     * 收款人真实姓名
     */
	@Size(max = 64)
    private String payeeRealName;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 完成时间
     */
    private Date finishTime;

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
