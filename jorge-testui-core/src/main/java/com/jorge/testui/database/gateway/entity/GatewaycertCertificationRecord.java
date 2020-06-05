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
 * 实名认证记录表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:26
 */
@Entity
@Table(name = "cert_certification_record")
@Getter
@Setter
public class GatewaycertCertificationRecord extends AbstractEntity {

    /**
     * 真实姓名
     */
	@NotEmpty
	@Size(max = 32)
    private String realName;

    /**
     * 身份证号
     */
	@NotEmpty
	@Size(max = 18)
    private String idCarNo;

    /**
     * 性别
     */
	@Size(max = 18)
    private String sex;

    /**
     * 所在地址
     */
	@Size(max = 512)
    private String address;

    /**
     * 出生日期
     */
	@Size(max = 32)
    private String birthday;

    /**
     * 状态
     */
    private Integer status;

}
