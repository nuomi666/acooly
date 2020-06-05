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
 * 支付引擎订单扩展表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:56
 */
@Entity
@Table(name = "pay_payengine_order_extend")
@Getter
@Setter
public class PaycorepayPayengineOrderExtend extends AbstractEntity {

    /**
     * 全站统一订单号
     */
	@Size(max = 64)
    private String gid;

    /**
     * 外部商户订单号
     */
	@Size(max = 64)
    private String merchBizOrderNo;

    /**
     * 支付订单号
     */
	@Size(max = 32)
    private String bizOrderNo;

    /**
     * 绑卡流水号
     */
	@Size(max = 64)
    private String bindNo;

    /**
     * 绑卡类型
     */
	@Size(max = 64)
    private String bindType;

    /**
     * 银行CODE
     */
	@Size(max = 16)
    private String bankCode;

    /**
     * 银行名称
     */
	@Size(max = 64)
    private String bankName;

    /**
     * 银行卡号
     */
	@Size(max = 32)
    private String bankCard;

    /**
     * 银行卡户名
     */
	@Size(max = 64)
    private String realName;

    /**
     * 身份证号
     */
	@Size(max = 20)
    private String certNo;

    /**
     * 对公对私标识
     */
	@Size(max = 2)
    private String publicTag;

    /**
     * 银行卡安全手机号
     */
	@Size(max = 16)
    private String mobileNo;

    /**
     * 产品类型
     */
	@Size(max = 96)
    private String productType;

    /**
     * 产品code
     */
	@Size(max = 32)
    private String productCode;

    /**
     * 产品信息
     */
	@Size(max = 256)
    private String productInfo;

    /**
     * 交易用途
     */
	@Size(max = 128)
    private String tradeUsage;

    /**
     * 跳转外部商户url
     */
	@Size(max = 512)
    private String returnUrl;

    /**
     * 开户行省
     */
	@Size(max = 64)
    private String province;

    /**
     * 开户行市
     */
	@Size(max = 64)
    private String city;

    /**
     * 银行卡类型
     */
	@Size(max = 16)
    private String bankCardType;

    /**
     * 三方交易类型
     */
	@Size(max = 32)
    private String thirdType;

    /**
     * 三方交易账户
     */
	@Size(max = 64)
    private String thirdUserNo;

    /**
     * 商品种类
     */
	@Size(max = 2)
    private String goodType;

    /**
     * 扩展字段
     */
	@Size(max = 2048)
    private String extContextJson;

    /**
     * 设备类型
     */
	@Size(max = 32)
    private String deviceType;

    /**
     * 微信OPENID
     */
	@Size(max = 64)
    private String openId;

    /**
     * 微信APPID
     */
	@Size(max = 64)
    private String appId;

    /**
     * 微信支付宝授权码
     */
	@Size(max = 128)
    private String authCode;

    /**
     * merch_order_no
     */
	@Size(max = 255)
    private String merchOrderNo;

    /**
     * pay_limit
     */
	@Size(max = 128)
    private String payLimit;

}
