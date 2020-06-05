/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-19
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
 * 会员进件资料表 Entity
 *
 * @author mufanglin
 * Date: 2019-12-19 15:24:41
 */
@Entity
@Table(name = "member_incoming_data")
@Getter
@Setter
public class MemberIncomingData extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 接入商编码
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * 类型
     */
	@NotEmpty
	@Size(max = 16)
    private String memberType;

    /**
     * 企业名称
     */
	@Size(max = 64)
    private String comName;

    /**
     * 法人姓名
     */
	@Size(max = 64)
    private String legalPersonName;

    /**
     * 店铺名称
     */
	@Size(max = 64)
    private String shopName;

    /**
     * 省
     */
	@Size(max = 64)
    private String prov;

    /**
     * 市
     */
	@Size(max = 64)
    private String city;

    /**
     * 区
     */
	@Size(max = 64)
    private String district;

    /**
     * 店铺详细地址
     */
	@Size(max = 128)
    private String shopAddress;

    /**
     * 是否允许审核
     */
	@Size(max = 16)
    private String isOpen;

    /**
     * 开通支付
     */
	@Size(max = 32)
    private String auditStatus;

    /**
     * 审核意见
     */
	@Size(max = 64)
    private String auditMemo;

    /**
     * 手持银行卡照片
     */
	@Size(max = 256)
    private String bustPhotoBankCard;

    /**
     * 经营场所室内照片
     */
	@Size(max = 256)
    private String businessPlaceIndoorPhoto;

    /**
     * 经营场所室外照片
     */
	@Size(max = 256)
    private String businessPlaceOutdoorPhoto;

    /**
     * 控股股东是否为法人
     */
	@Size(max = 16)
    private String isHolderLegal;

    /**
     * 控股股东身份证正面照片
     */
	@Size(max = 256)
    private String holdingCertFrontPath;

    /**
     * 控股股东身份证背面照片
     */
	@Size(max = 256)
    private String holdingCertBackPath;

    /**
     * 受益人所有人是否为法人
     */
	@Size(max = 16)
    private String isBeneficiaryLegal;

    /**
     * 受益人身份证正面照
     */
	@Size(max = 256)
    private String beneficiaryCertFrontPath;

    /**
     * 受益人身份证背面照
     */
	@Size(max = 256)
    private String beneficiaryCertBackPath;

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
     * 营业执照证件号
     */
    @Size(max = 64)
    private String individualCertificate;

    /**
     * 营业执照证件号照片
     */
    @Size(max = 128)
    private String individualCertificatePhoto;

    /**
     * 经营范围
     */
    @Size(max = 512)
    private String businessScope;

    /**
     * 营业执照有效期开始时间
     */
    @Size(max = 32)
    private String individualCertificateStart;

    /**
     * 营业执照有效期到期时间
     */
    @Size(max = 32)
    private String individualCertificateEnd;

    /**
     * 营业执照证件地址
     */
    @Size(max = 32)
    private String individualCertificateAddress;

    /**
     * 注册资本金
     */
    private String registeredCapital;

    /**
     * 注册资本金币种
     */
    @Size(max = 32)
    private String registeredCapitalGoldCoins;

    /**
     * 法人手机号
     */
    @Size(max = 32)
    private String legalPersonMobile;

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
     * 法人国籍
     */
    @Size(max = 64)
    private String legalPersonNationality;

    /**
     * 法人性别
     */
    @Size(max = 11)
    private String legalPersonGender;

    /**
     * 法人户籍地址
     */
    @Size(max = 128)
    private String legalPersonAddress;

    /**
     * 法定代表人/个体经营者证件签发地址
     */
    @Size(max = 128)
    private String legalCertAddress;

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
     * 客服电话
     */
    @Size(max = 20)
    private String customerServicePhone;

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
     * 受益人证件证件签发地址
     */
    @Size(max = 128)
    private String beneficiaryCertAddress;

    /**
     * 开户许可证图片
     */
    @Size(max = 512)
    private String openAccountPath;

    /**
     * 门头照
     */
    @Size(max = 128)
    private String shopDoorPhoto;
}
