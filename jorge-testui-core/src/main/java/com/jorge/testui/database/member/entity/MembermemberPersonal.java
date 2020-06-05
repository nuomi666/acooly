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
 * 个人用户实名认证 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:17
 */
@Entity
@Table(name = "member_personal")
@Getter
@Setter
public class MembermemberPersonal extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 真实姓名
     */
	@Size(max = 32)
    private String realName;

    /**
     * 实名认证
     */
	@Size(max = 16)
    private String authStatus;

    /**
     * 等级
     */
	@Size(max = 20)
    private String grade;

    /**
     * 性别
     */
	@Size(max = 11)
    private String gender;

    /**
     * 国家
     */
	@Size(max = 11)
    private String nation;

    /**
     * 证件类型
     */
	@Size(max = 11)
    private String certType;

    /**
     * 证件号码
     */
	@Size(max = 32)
    private String certNo;

    /**
     * 身份证有效期开始时间
     */
	@Size(max = 32)
    private String certValidityStart;

    /**
     * 身份证有效期j结束时间
     */
	@Size(max = 32)
    private String certValidityEnd;

    /**
     * 居住地 省
     */
	@Size(max = 64)
    private String birthProvince;

    /**
     * 居住地 市
     */
	@Size(max = 64)
    private String birthCity;

    /**
     * 居住地 县/区
     */
	@Size(max = 64)
    private String birthCounty;

    /**
     * 证件正面图片
     */
	@Size(max = 128)
    private String certFront;

    /**
     * 证件背面图片
     */
	@Size(max = 128)
    private String certBack;

    /**
     * 手持身份证正面半身照片
     */
	@Size(max = 128)
    private String bustphotoCertFront;

    /**
     * 常住地址
     */
	@Size(max = 256)
    private String address;

    /**
     * 出生日期
     */
	@Size(max = 10)
    private String birthDay;

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
     * 全站统一订单号
     */
	@Size(max = 64)
    private String gid;

    /**
     * 备注
     */
	@Size(max = 512)
    private String comments;

    /**
     * 认证失败原因
     */
	@Size(max = 256)
    private String failReason;

    /**
     * 是否boss审核
     */
	@Size(max = 20)
    private String isBossVerify;

    /**
     * 审核状态
     */
	@Size(max = 20)
    private String validStatusEnum;

    /**
     * valid_status
     */
	@Size(max = 255)
    private String validStatus;

}
