/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-11
*/
package com.jorge.testui.database.openapi.entity;


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
 * 请求信息表 Entity
 *
 * @author mufanglin
 * Date: 2019-12-11 10:58:11
 */
@Entity
@Table(name = "api_order_info")
@Getter
@Setter
public class ApiOrderInfo extends AbstractEntity {

    /**
     * 访问key
     */
	@NotEmpty
	@Size(max = 40)
    private String accessKey;

    /**
     * 商户ID
     */
	@NotEmpty
	@Size(max = 40)
    private String partnerId;

    /**
     * 统一流水
     */
	@NotEmpty
	@Size(max = 40)
    private String gid;

    /**
     * 请求号
     */
	@NotEmpty
	@Size(max = 40)
    private String requestNo;

    /**
     * 服务名
     */
	@NotEmpty
	@Size(max = 32)
    private String service;

    /**
     * 版本号
     */
	@NotEmpty
	@Size(max = 8)
    private String version;

    /**
     * 签名类型
     */
	@Size(max = 16)
    private String signType;

    /**
     * 协议
     */
	@Size(max = 40)
    private String protocol;

    /**
     * 通知地址
     */
	@Size(max = 512)
    private String notifyUrl;

    /**
     * 返回地址
     */
	@Size(max = 512)
    private String returnUrl;

    /**
     * 扩展信息
     */
	@Size(max = 1024)
    private String businessInfo;

    /**
     * 会话信息
     */
	@Size(max = 128)
    private String context;

    /**
     * 创建时间
     */
	@NotNull
    private Date rawAddTime;

    /**
     * 修改时间
     */
	@NotNull
    private Date rawUpdateTime;

}
