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
 * 企业用户实名认证 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:16
 */
@Entity
@Table(name = "member_enterprise")
@Getter
@Setter
public class MembermemberEnterprise extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 联系人姓名
     */
	@Size(max = 64)
    private String contactName;

    /**
     * 联系人手机号
     */
	@Size(max = 16)
    private String contactMobile;

    /**
     * 联系人邮箱
     */
	@Size(max = 64)
    private String contactEmail;

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
     * 企业名称
     */
	@Size(max = 64)
    private String comName;

    /**
     * 门头照
     */
	@Size(max = 128)
    private String shopDoorPhoto;

    /**
     * 法人姓名
     */
	@Size(max = 64)
    private String legalPersonName;

    /**
     * 法人手机号
     */
	@Size(max = 32)
    private String legalPersonMobile;

    /**
     * 法人证件类型: 默认身份证
     */
	@Size(max = 64)
    private String legalPersonCertType;

    /**
     * 法人证件号码
     */
	@Size(max = 64)
    private String legalPersonCertNo;

    /**
     * 法人证件开始时间
     */
	@Size(max = 64)
    private String legalPersonCertTimeStart;

    /**
     * 法人证件到期时间
     */
	@Size(max = 64)
    private String legalPersonCertTimeEnd;

    /**
     * 法人证件正面图片
     */
	@Size(max = 512)
    private String legalPersonCertFrontPath;

    /**
     * 法人证件背面图片
     */
	@Size(max = 512)
    private String legalPersonCertBackPath;

    /**
     * 性别
     */
	@Size(max = 11)
    private String legalPersonGender;

    /**
     * 法人户籍地址
     */
	@Size(max = 128)
    private String legalPersonAddress;

    /**
     * 法人民族
     */
	@Size(max = 32)
    private String legalPersonNation;

    /**
     * 公司地址
     */
	@Size(max = 128)
    private String address;

    /**
     * 联系电话
     */
	@Size(max = 20)
    private String phone;

    /**
     * 省
     */
	@Size(max = 20)
    private String prov;

    /**
     * 市
     */
	@Size(max = 20)
    private String city;

    /**
     * 区
     */
	@Size(max = 20)
    private String district;

    /**
     * 经营范围
     */
	@Size(max = 512)
    private String businessScope;

    /**
     * 营业年限
     */
	@Size(max = 16)
    private String comCycle;

    /**
     * 注册资金
     */
	@Size(max = 32)
    private String registeredCapital;

    /**
     * 营业执照编号
     */
	@Size(max = 64)
    private String licenceNo;

    /**
     * 营业执照图片地址
     */
	@Size(max = 512)
    private String licencePath;

    /**
     * 营业执照有效期开始时间
     */
	@Size(max = 32)
    private String licenceTimeStart;

    /**
     * 营业执照有效期结束时间
     */
	@Size(max = 32)
    private String licenceTimeEnd;

    /**
     * 营业执照签发地址
     */
	@Size(max = 128)
    private String licenceAddress;

    /**
     * 组织机构代码证号
     */
	@Size(max = 64)
    private String organizationCode;

    /**
     * 组织机构代码证图片
     */
	@Size(max = 512)
    private String organizationCodePath;

    /**
     * 实际控股人或企业类型
     */
	@Size(max = 32)
    private String holdingEnum;

    /**
     * 股东或实际控制人真实姓名
     */
	@Size(max = 64)
    private String holdingName;

    /**
     * 股东或实际控制人证件号
     */
	@Size(max = 64)
    private String holdingCertNo;

    /**
     * 股东或实际控制人证件类型
     */
	@Size(max = 64)
    private String holdingCertType;

    /**
     * 股东或实际控制人证件开始时间
     */
	@Size(max = 64)
    private String holdingCertTimeStart;

    /**
     * 股东或实际控制人证件到期时间
     */
	@Size(max = 64)
    private String holdingCertTimeEnd;

    /**
     * 股东或实际控制人证件正面图片
     */
	@Size(max = 512)
    private String holdingCertFrontPath;

    /**
     * 股东或实际控制人证件背面图片
     */
	@Size(max = 512)
    private String holdingCertBackPath;

    /**
     * 开户许可证号码
     */
	@Size(max = 32)
    private String openAccountNo;

    /**
     * 开户许可证图片
     */
	@Size(max = 512)
    private String openAccountPath;

    /**
     * 税务登记证号码
     */
	@Size(max = 32)
    private String taxAuthorityNo;

    /**
     * 税务登记证图片
     */
	@Size(max = 512)
    private String taxAuthorityPath;

    /**
     * 受益人姓名
     */
	@Size(max = 64)
    private String beneficiaryName;

    /**
     * 受益人证件类型
     */
	@Size(max = 64)
    private String beneficiaryCertType;

    /**
     * 受益人身份证号
     */
	@Size(max = 64)
    private String beneficiaryCertNo;

    /**
     * 受益人证件开始时间
     */
	@Size(max = 32)
    private String beneficiaryCertTimeStart;

    /**
     * 受益人证件到期时间
     */
	@Size(max = 32)
    private String beneficiaryCertTimeEnd;

    /**
     * 受益人身份证正面照
     */
	@Size(max = 512)
    private String beneficiaryCertFrontPath;

    /**
     * 受益人身份证背面照
     */
	@Size(max = 512)
    private String beneficiaryCertBackPath;

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
     * 认证失败原因
     */
	@Size(max = 256)
    private String failReason;

    /**
     * 备注
     */
	@Size(max = 512)
    private String comments;

    /**
     * holding_type
     */
	@Size(max = 255)
    private String holdingType;

    /**
     * valid_status
     */
	@Size(max = 255)
    private String validStatus;

}
