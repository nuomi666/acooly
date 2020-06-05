/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-03-10
*/
package com.jorge.testui.database.member.entity;


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
 * 二类户开户表 Entity
 *
 * @author mufanglin
 * @date 2020-03-10 12:27:11
 */
@Entity
@Table(name = "member_twoaccount")
@Getter
@Setter
public class MemberTwoaccount extends AbstractEntity {

    /**
     * 用户编码
     */
	@Size(max = 64)
    private String userNo;

    /**
     * account_no
     */
	@Size(max = 32)
    private String accountNo;

    /**
     * 会员姓名
     */
	@Size(max = 50)
    private String realName;

    /**
     * 二代身份证号码
     */
	@Size(max = 32)
    private String idCardNo;

    /**
     * 证件签发日期
     */
	@Size(max = 16)
    private String cardStartDate;

    /**
     * 证件到期日期
     */
	@Size(max = 16)
    private String cardEndDate;

    /**
     * 名族
     */
	@Size(max = 8)
    private String nation;

    /**
     * 证件签发机关
     */
	@Size(max = 64)
    private String cardIssuingAuthority;

    /**
     * 户籍地址
     */
	@Size(max = 255)
    private String homeAddr;

    /**
     * 手机号码
     */
	@Size(max = 18)
    private String mobileNo;

    /**
     * 绑定一类银行账号
     */
	@Size(max = 64)
    private String bankCardNo;

    /**
     * 职业
     */
	@Size(max = 64)
    private String job;

    /**
     * 活体影像-图片
     */
	@Size(max = 255)
    private String custVideoPic;

    /**
     * 身份证人像面
     */
	@Size(max = 255)
    private String idcardFront;

    /**
     * 身份证国徽面
     */
	@Size(max = 255)
    private String idcardBack;

    /**
     * gid
     */
	@Size(max = 64)
    private String gid;

    /**
     * partner_id
     */
	@Size(max = 64)
    private String partnerId;

    /**
     * merch_order_no
     */
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 状态
     */
	@Size(max = 32)
    private String openStatus;

}
