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
import java.util.Date;

/**
 * 用户账户变动表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:54
 */
@Entity
@Table(name = "act_account_change")
@Getter
@Setter
public class PaycoreactAccountChange extends AbstractEntity {

    /**
     * 用户编码
     */
	@Size(max = 32)
    private String userNo;

    /**
     * 用户名
     */
	@Size(max = 32)
    private String userName;

    /**
     * 账务操作类型
     */
	@Size(max = 16)
    private String orderType;

    /**
     * 顶层交易类型
     */
	@Size(max = 32)
    private String tradeType;

    /**
     * 账户类型
     */
	@Size(max = 32)
    private String accountType;

    /**
     * 账户号
     */
	@Size(max = 64)
    private String accountNo;

    /**
     * 变动类型
     */
	@Size(max = 16)
    private String changeType;

    /**
     * 变动方向
     */
	@Size(max = 8)
    private String changeDirection;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 交易后余额
     */
    private Long balance;

    /**
     * 冻结变动方向
     */
	@Size(max = 16)
    private String freezeDirection;

    /**
     * 冻结类型
     */
	@Size(max = 32)
    private String freezeType;

    /**
     * 冻结金额
     */
    private Long freezeAmount;

    /**
     * 冻结变动后总余额
     */
    private Long freezeBalance;

    /**
     * 冻结变动后指定冻结账户余额
     */
    private Long freezeTypeBalance;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 相关用户编码
     */
	@Size(max = 32)
    private String refUserNo;

    /**
     * 相关账户号
     */
	@Size(max = 32)
    private String refAccountNo;

    /**
     * 内部备注
     */
	@Size(max = 128)
    private String memo;

    /**
     * 外部备注
     */
	@Size(max = 128)
    private String comments;

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
     * 订单号
     */
	@Size(max = 32)
    private String bizOrderNo;

    /**
     * 接入商ID
     */
	@Size(max = 32)
    private String partnerId;

    /**
     * freeze_leave
     */
    private Long freezeLeave;

    /**
     * transfer_type
     */
	@Size(max = 255)
    private String transferType;

}
