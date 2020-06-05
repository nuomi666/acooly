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
 * 用户资金账户 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:14
 */
@Entity
@Table(name = "member_account")
@Getter
@Setter
public class MembermemberAccount extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 用户账务号
     */
	@NotEmpty
	@Size(max = 64)
    private String accountNo;

    /**
     * 银行账户号
     */
	@Size(max = 64)
    private String bankAccountNo;

    /**
     * 渠道二级账户
     */
	@Size(max = 64)
    private String bankAccountCoreNo;

    /**
     * 类型
     */
	@Size(max = 16)
    private String memberType;

    /**
     * 账务类型
     */
	@Size(max = 16)
    private String accountType;

    /**
     * 状态
     */
	@Size(max = 32)
    private String openStatus;

    /**
     * 备注
     */
	@Size(max = 256)
    private String comments;

    /**
     * 业务订单号
     */
	@Size(max = 64)
    private String bizOrderNo;

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
     * 所属运营商id
     */
	@Size(max = 32)
    private String partnerId;

}
