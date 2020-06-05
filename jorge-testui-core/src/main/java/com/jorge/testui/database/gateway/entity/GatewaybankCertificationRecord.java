/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.gateway.entity;


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
 * 银行卡四要素记录表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:25
 */
@Entity
@Table(name = "bank_certification_record")
@Getter
@Setter
public class GatewaybankCertificationRecord extends AbstractEntity {

    /**
     * 持卡人姓名
     */
	@NotEmpty
	@Size(max = 20)
    private String realName;

    /**
     * 银行卡帐号
     */
	@NotEmpty
	@Size(max = 32)
    private String cardNo;

    /**
     * 开卡使用的证件号码
     */
	@Size(max = 18)
    private String certId;

    /**
     * 绑定手机号
     */
	@Size(max = 32)
    private String phoneNum;

    /**
     * 开卡使用的证件类型
     */
	@Size(max = 10)
    private String certType;

    /**
     * 银行卡归属地
     */
	@Size(max = 32)
    private String belongArea;

    /**
     * 银行客服
     */
	@Size(max = 32)
    private String bankTel;

    /**
     * 银行卡产品名称
     */
	@Size(max = 32)
    private String brand;

    /**
     * 银行名称
     */
	@Size(max = 64)
    private String bankName;

    /**
     * 银行卡种
     */
	@Size(max = 32)
    private String cardType;

    /**
     * 银行官网
     */
	@Size(max = 32)
    private String bankUrl;

    /**
     * 验证失败原因
     */
	@Size(max = 100)
    private String failReason;

    /**
     * 状态
     */
    private Integer status;

}
