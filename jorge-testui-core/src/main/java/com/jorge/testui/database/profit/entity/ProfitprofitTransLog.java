/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.profit.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * profit_trans_log Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:05:04
 */
@Entity
@Table(name = "profit_trans_log")
@Getter
@Setter
public class ProfitprofitTransLog extends AbstractEntity {

    /**
     * 清分交易流水号
     */
	@Size(max = 32)
    private String transNo;

    /**
     * 清分交易子流水号
     */
	@Size(max = 32)
    private String transsNo;

    /**
     * 清分主订单流水号
     */
	@Size(max = 32)
    private String profitNo;

    /**
     * 清分子订单流水号
     */
	@Size(max = 32)
    private String profitsNo;

    /**
     * 账务流水号
     */
	@Size(max = 64)
    private String accountBizNo;

    /**
     * 付款人角色
     */
	@Size(max = 32)
    private String payerRole;

    /**
     * 付款人ID
     */
	@Size(max = 32)
    private String payerUserId;

    /**
     * 付款账户
     */
	@Size(max = 32)
    private String payerAccount;

    /**
     * 收款角色
     */
	@Size(max = 32)
    private String payeeRole;

    /**
     * 收款人ID
     */
	@Size(max = 32)
    private String payeeUserId;

    /**
     * 收款账户
     */
	@Size(max = 32)
    private String payeeAccount;

    /**
     * 清分金额
     */
    private Long profitAmount;

    /**
     * 清分状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 清分方式
     */
	@Size(max = 32)
    private String calType;

    /**
     * 清分费率
     */
	@Size(max = 32)
    private String calRate;

    /**
     * 备注
     */
	@Size(max = 255)
    private String memo;

    /**
     * 失败次数
     */
    private Integer failCount;

    /**
     * 失败原因描述
     */
	@Size(max = 255)
    private String failReason;

}
