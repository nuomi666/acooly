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
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * profit_transfer Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:05:04
 */
@Entity
@Table(name = "profit_transfer")
@Getter
@Setter
public class ProfitprofitTransfer extends AbstractEntity {

    /**
     * 清分主订单流水号
     */
	@NotEmpty
	@Size(max = 32)
    private String profitNo;

    /**
     * 清分子订单流水号
     */
	@NotEmpty
	@Size(max = 64)
    private String bizOrderNo;

    /**
     * 付款人角色
     */
	@NotEmpty
	@Size(max = 32)
    private String payerRole;

    /**
     * 付款人ID
     */
	@NotEmpty
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
	@NotEmpty
	@Size(max = 32)
    private String payeeRole;

    /**
     * 收款人ID
     */
	@NotEmpty
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
	@NotNull
    private Long transferAmount;

    /**
     * 清分状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * 备注
     */
	@Size(max = 255)
    private String memo;

}
