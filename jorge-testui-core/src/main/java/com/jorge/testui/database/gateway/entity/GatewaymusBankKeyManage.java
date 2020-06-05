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
import java.util.Date;

/**
 * 银行密钥管理 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:27
 */
@Entity
@Table(name = "mus_bank_key_manage")
@Getter
@Setter
public class GatewaymusBankKeyManage extends AbstractEntity {

    /**
     * 商户名称
     */
	@Size(max = 128)
    private String merchName;

    /**
     * 渠道商户号
     */
	@Size(max = 128)
    private String merchId;

    /**
     * 渠道MD5密钥
     */
	@Size(max = 256)
    private String merchKey;

    /**
     * 扩展参数
     */
	@Size(max = 256)
    private String extendParams;

    /**
     * 备注
     */
	@Size(max = 128)
    private String memo;

    /**
     * app_id
     */
	@Size(max = 255)
    private String appId;

    /**
     * bank_type
     */
	@Size(max = 255)
    private String bankType;

    /**
     * enabled
     */
	@Size(max = 255)
    private String enabled;

}
