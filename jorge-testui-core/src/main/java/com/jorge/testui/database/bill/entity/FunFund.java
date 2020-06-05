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
 * 充值提现订单 Entity
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
@Entity
@Table(name = "fun_fund")
@Getter
@Setter
public class FunFund extends AbstractEntity {

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
     * 支付交易号
     */
	@Size(max = 64)
    private String tradeNo;

    /**
     * 支付订单号
     */
	@Size(max = 64)
    private String payOrderNo;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 付款类型
     */
	@NotEmpty
	@Size(max = 32)
    private String type;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * T0
     */
	@Size(max = 32)
    private String delay;

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
     * 交易金额
     */
	@NotNull
    private Long amount;

    /**
     * 收费金额
     */
    private Long chargeAmount;

    /**
     * 实际到账金额
     */
    private Long actualAmount;

    /**
     * 平台类型
     */
	@Size(max = 32)
    private String platformType;

    /**
     * 真实姓名
     */
	@Size(max = 64)
    private String realName;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 所属运营商id
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * 对公对私
     */
	@Size(max = 40)
    private String publicTag;

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
     * 是否收费
     */
	@Size(max = 32)
    private String isCharge;

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
     * 备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * trade_memo
     */
	@Size(max = 255)
    private String tradeMemo;

    /**
     * fee_user_no
     */
	@Size(max = 255)
    private String feeUserNo;

    /**
     * charge_user_no
     */
	@Size(max = 255)
    private String chargeUserNo;

    /**
     * actual_charge_amount
     */
    private Integer actualChargeAmount;

    /**
     * charge_payee_user_no
     */
	@Size(max = 255)
    private String chargePayeeUserNo;

    /**
     * charge_payer_user_no
     */
	@Size(max = 255)
    private String chargePayerUserNo;

    /**
     * 手续费支付角色
     */
	@Size(max = 20)
    private String feePayRole;

    /**
     * 手续费支付会员id
     */
	@Size(max = 32)
    private String feePayUserNo;

    /**
     * 账期
     */
	@Size(max = 12)
    private String periodNo;

}
