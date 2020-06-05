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
 * 用户信息表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:14
 */
@Entity
@Table(name = "member")
@Getter
@Setter
public class Membermember extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 外部用户唯一ID
     */
	@NotEmpty
	@Size(max = 64)
    private String merchUserNo;

    /**
     * 手机号码
     */
	@Size(max = 11)
    private String mobileNo;

    /**
     * 邮箱
     */
	@Size(max = 64)
    private String email;

    /**
     * 类型
     */
	@NotEmpty
	@Size(max = 16)
    private String memberType;

    /**
     * 状态
     */
	@Size(max = 16)
    private String memberStatus;

    /**
     * 实名认证
     */
	@Size(max = 16)
    private String realNameAuth;

    /**
     * 手机认证
     */
	@Size(max = 16)
    private String mobileNoAuth;

    /**
     * 邮箱认证
     */
	@Size(max = 16)
    private String emailAuth;

    /**
     * 开户状态
     */
	@Size(max = 32)
    private String merchantOpenStatus;

    /**
     * 开通支付
     */
	@Size(max = 32)
    private String aggregatePayStatus;

    /**
     * 开通支付
     */
	@Size(max = 32)
    private String posPayStatus;

    /**
     * 开通支付
     */
	@Size(max = 32)
    private String cardPayStatus;

    /**
     * 设置操作员状态
     */
	@Size(max = 32)
    private String operatorAddStatus;

    /**
     * 代理商id
     */
	@Size(max = 32)
    private String agentId;

    /**
     * 业务员id
     */
	@Size(max = 32)
    private String salesmanId;

    /**
     * 备注
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
     * 业务订单
     */
	@Size(max = 64)
    private String bizOrderNo;

    /**
     * 注册客户端
     */
	@Size(max = 64)
    private String registerClient;

    /**
     * 注册来源:
     */
	@Size(max = 64)
    private String registerSource;

    /**
     * 所属运营商id
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * user_ip
     */
	@Size(max = 32)
    private String userIp;


	private String paymentCompetenceNum;

}
