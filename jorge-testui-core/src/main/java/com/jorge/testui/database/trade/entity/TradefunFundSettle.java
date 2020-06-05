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
 * 资金结算管理 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:32
 */
@Entity
@Table(name = "fun_fund_settle")
@Getter
@Setter
public class TradefunFundSettle extends AbstractEntity {

    /**
     * 用户号
     */
	@NotEmpty
	@Size(max = 32)
    private String userNo;

    /**
     * 用户名
     */
	@Size(max = 32)
    private String userName;

    /**
     * 账户号
     */
	@Size(max = 32)
    private String accountNo;

    /**
     * 状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * 触发自动提现金额
     */
	@NotNull
    private Long minAmount;

    /**
     * 银行卡类型
     */
	@Size(max = 40)
    private String bankCardType;

    /**
     * 银行编码
     */
	@Size(max = 20)
    private String bankCode;

    /**
     * 银行名称
     */
	@Size(max = 64)
    private String bankName;

    /**
     * 手机号码
     */
	@Size(max = 20)
    private String mobileNo;

    /**
     * 银行卡号
     */
	@Size(max = 32)
    private String bankCardNo;

    /**
     * 联行号
     */
	@Size(max = 32)
    private String bankCnapsNo;

    /**
     * 银行卡真实名称
     */
	@Size(max = 64)
    private String bankRealName;

    /**
     * 绑卡编号
     */
	@Size(max = 64)
    private String bindNo;

    /**
     * 异步通知地址
     */
	@Size(max = 128)
    private String notifyUrl;

    /**
     * 所属运营商id
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * 备注
     */
	@Size(max = 64)
    private String memo;

    /**
     * bind_type
     */
	@Size(max = 255)
    private String bindType;

}
