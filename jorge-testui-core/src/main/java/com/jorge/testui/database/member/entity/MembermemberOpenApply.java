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
 * 会员开通支付能力申请订单 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:16
 */
@Entity
@Table(name = "member_open_apply")
@Getter
@Setter
public class MembermemberOpenApply extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 类型
     */
	@Size(max = 16)
    private String memberType;

    /**
     * 公司名称
     */
	@Size(max = 64)
    private String comName;

    /**
     * 法人姓名
     */
	@Size(max = 64)
    private String realName;

    /**
     * 支付类型:
     */
	@NotEmpty
	@Size(max = 32)
    private String paymentType;

    /**
     * 经营活动室内照片
     */
	@Size(max = 512)
    private String indoorImagePath;

    /**
     * 经营活动室外照片
     */
	@Size(max = 512)
    private String outdoorImagePath;

    /**
     * 控股股东证件正面图片
     */
	@Size(max = 512)
    private String holdCertFrontPath;

    /**
     * 控股股东证件背面图片
     */
	@Size(max = 512)
    private String holdCertBackPath;

    /**
     * 受益人股东证件正面图片
     */
	@Size(max = 512)
    private String beneficiaryCertFrontPath;

    /**
     * 受益人股东证件背面图片
     */
	@Size(max = 512)
    private String beneficiaryCertBackPath;

    /**
     * 店铺信息
     */
	@Size(max = 2048)
    private String shopInfo;

    /**
     * 审核结果
     */
	@Size(max = 255)
    private String validMessage;

    /**
     * 审核状态
     */
	@Size(max = 32)
    private String validStatus;

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
     * 业务订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String bizOrderNo;

    /**
     * 外部商户订单号
     */
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 所属运营商id
     */
	@Size(max = 32)
    private String partnerId;

    private String publicAppId;
    private String publicAuthDir;
    private String smallProgramAppId;
    private String weChatAppId;
    private String zfbAppId;
    private String zfbLifeAppId;
    private String applyModel;
}
