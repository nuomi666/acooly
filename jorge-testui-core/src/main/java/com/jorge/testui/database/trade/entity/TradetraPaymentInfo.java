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
 * 通用交易支付信息 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:33
 */
@Entity
@Table(name = "tra_payment_info")
@Getter
@Setter
public class TradetraPaymentInfo extends AbstractEntity {

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
	@Size(max = 64)
    private String payOrderNo;

    /**
     * appid
     */
	@Size(max = 64)
    private String appId;

    /**
     * 授权码
     */
	@Size(max = 64)
    private String authCode;

    /**
     * open_id
     */
	@Size(max = 64)
    private String openId;

    /**
     * 产品编码
     */
	@Size(max = 64)
    private String productCode;

    /**
     * 产品类型
     */
	@Size(max = 32)
    private String productType;

    /**
     * 产品信息
     */
	@Size(max = 64)
    private String productInfo;

    /**
     * return_url
     */
	@Size(max = 255)
    private String returnUrl;

    /**
     * user_ip
     */
	@Size(max = 32)
    private String userIp;

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
     * 真实姓名
     */
	@Size(max = 64)
    private String realName;

}
