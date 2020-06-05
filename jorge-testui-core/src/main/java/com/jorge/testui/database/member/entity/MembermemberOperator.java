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
 * 操作员管理表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:17
 */
@Entity
@Table(name = "member_operator")
@Getter
@Setter
public class MembermemberOperator extends AbstractEntity {

    /**
     * 操作员账户名
     */
	@NotEmpty
	@Size(max = 64)
    private String operatorNo;

    /**
     * 关联用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 登录名称
     */
	@NotEmpty
	@Size(max = 64)
    private String userName;

    /**
     * 登录密码密盐
     */
	@Size(max = 64)
    private String loginSalt;

    /**
     * 登录密码
     */
	@Size(max = 64)
    private String loginPassword;

    /**
     * 登录密码失败次数
     */
    private Integer loginPasswordErrorTimes;

    /**
     * 登录密码验证失败时间
     */
    private Date lastLoginFailTime;

    /**
     * 修改登录密码时间
     */
    private Date modifyLoginPasswordTime;

    /**
     * 支付密码密盐
     */
	@Size(max = 64)
    private String paySalt;

    /**
     * 支付密码
     */
	@Size(max = 64)
    private String payPassword;

    /**
     * 验证支付密码失败次数
     */
    private Integer payPasswordErrorTimes;

    /**
     * 支付密码验证失败时间
     */
    private Date lastPayFailTime;

    /**
     * 修改支付密码时间
     */
    private Date modifyPayPasswordTime;

    /**
     * 真实姓名
     */
	@Size(max = 64)
    private String realName;

    /**
     * 手机号
     */
	@Size(max = 64)
    private String mobileNo;

    /**
     * 默认操作员
     */
	@Size(max = 32)
    private String isDefaultOperator;

    /**
     * 状态
     */
	@Size(max = 16)
    private String operatorStatus;

    /**
     * 所属运营商id
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * 外部商户订单号
     */
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 全站统一订单号
     */
	@Size(max = 64)
    private String gid;

    /**
     * 备注
     */
	@Size(max = 128)
    private String comments;

}
