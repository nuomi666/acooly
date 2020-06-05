/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.member.entity;


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
 * 用户绑卡列表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:15
 */
@Entity
@Table(name = "member_bank_card")
@Getter
@Setter
public class MembermemberBankCard extends AbstractEntity {

    /**
     * 绑卡编码
     */
	@Size(max = 64)
    private String bindNo;

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 手机号码
     */
	@Size(max = 32)
    private String mobileNo;

    /**
     * 真实姓名
     */
	@Size(max = 64)
    private String realName;

    /**
     * 证件号码
     */
	@Size(max = 32)
    private String certNo;

    /**
     * 银行名称
     */
	@Size(max = 16)
    private String bankCode;

    /**
     * 银行卡号
     */
	@Size(max = 64)
    private String bankCardNo;

    /**
     * 卡种
     */
	@Size(max = 16)
    private String bankCardType;

    /**
     * 银行联行号
     */
	@Size(max = 32)
    private String bankCnapsNo;

    /**
     * 银行支行名称
     */
	@Size(max = 128)
    private String bankSubbranch;

    /**
     * 银行卡账户类型,
     */
	@Size(max = 16)
    private String publicTag;

    /**
     * 开户省
     */
	@Size(max = 32)
    private String province;

    /**
     * 开户市
     */
	@Size(max = 32)
    private String city;

    /**
     * 协议号
     */
	@Size(max = 64)
    private String protocolNo;

    /**
     * 绑卡类型
     */
	@Size(max = 64)
    private String bindType;

    /**
     * 是否验证短信:
     */
	@Size(max = 64)
    private String isValidateSms;

    /**
     * 绑卡用途
     */
	@Size(max = 64)
    private String purpose;

    /**
     * 身份证正面照
     */
	@Size(max = 512)
    private String certFrontPath;

    /**
     * 身份证反面照
     */
	@Size(max = 512)
    private String certBackPath;

    /**
     * 手持身份证照
     */
	@Size(max = 512)
    private String holdCertPath;

    /**
     * 银行卡正面照
     */
	@Size(max = 512)
    private String bankCardFrontPath;

    /**
     * 授权委托书盖章照
     */
	@Size(max = 512)
    private String attorneyPowerPath;

    /**
     * 状态
     */
	@Size(max = 64)
    private String cardStatus;

    /**
     * 审核状态
     */
	@Size(max = 64)
    private String validStatus;

    /**
     * 审核结果
     */
	@Size(max = 256)
    private String validMessage;

    /**
     * 运营商编号
     */
	@Size(max = 32)
    private String partnerId;

    /**
     * 外部商户订单号
     */
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 平台内部订单号
     */
	@Size(max = 32)
    private String bizOrderNo;

    /**
     * 全站统一订单号
     */
	@Size(max = 64)
    private String gid;

    /**
     * 备注
     */
	@Size(max = 255)
    private String comments;

    /**
     * is_fintech_sms
     */
	@Size(max = 16)
    private String isFintechSms;

}
