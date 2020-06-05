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
 * 个体户实名认证表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:16
 */
@Entity
@Table(name = "member_individual")
@Getter
@Setter
public class MembermemberIndividual extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

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
     * 负责人真实姓名
     */
	@Size(max = 32)
    private String realName;

    /**
     * 负责人手机号
     */
	@Size(max = 32)
    private String mobileNo;

    /**
     * 负责人性别
     */
	@Size(max = 11)
    private String gender;

    /**
     * 负责人民族
     */
	@Size(max = 11)
    private String nation;

    /**
     * 负责人证件类型
     */
	@Size(max = 11)
    private String certType;

    /**
     * 负责人证件号码
     */
	@Size(max = 32)
    private String certNo;

    /**
     * 负责人身份证有效期开始时间
     */
	@Size(max = 32)
    private String certValidityTimeStart;

    /**
     * 负责人身份证有效期结束时间
     */
	@Size(max = 32)
    private String certValidityTimeEnd;

    /**
     * 负责人居住地址
     */
	@Size(max = 255)
    private String address;

    /**
     * 负责人出生日期
     */
	@Size(max = 10)
    private String birthDay;

    /**
     * 负责人证件正面图片
     */
	@Size(max = 128)
    private String certFront;

    /**
     * 负责人证件背面图片
     */
	@Size(max = 128)
    private String certBack;

    /**
     * 负责人手持身份证正面半身照片
     */
	@Size(max = 128)
    private String bustphotoCertFront;

    /**
     * 门头照
     */
	@Size(max = 128)
    private String shopDoorPhoto;

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
     * 公司地址
     */
	@Size(max = 256)
    private String comAddress;

    /**
     * 企业名称
     */
	@Size(max = 64)
    private String comName;

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
	@Size(max = 128)
    private String individualCertificateAddress;

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
