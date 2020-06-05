/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.paycore.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 支付引擎网关订单表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:56
 */
@Entity
@Table(name = "pay_payengine_gateway_order")
@Getter
@Setter
public class PaycorepayPayengineGatewayOrder extends AbstractEntity {

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
     * 订单号
     */
	@Size(max = 32)
    private String bizOrderNo;

    /**
     * 用户编码
     */
	@Size(max = 32)
    private String userNo;

    /**
     * 网关类型
     */
	@Size(max = 64)
    private String service;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 实际到账金额
     */
    private Long amountIn;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 返回结果CODE
     */
	@Size(max = 32)
    private String resultCode;

    /**
     * 返回结果描述
     */
	@Size(max = 512)
    private String resultMessage;

    /**
     * 请求时间
     */
    private Date requestTime;

    /**
     * 通知时间
     */
    private Date notifyTime;

    /**
     * 同步/异步标识
     */
	@Size(max = 6)
    private String isSyn;

    /**
     * 本地处理备注
     */
	@Size(max = 3072)
    private String comments;

    /**
     * 网关透传字段
     */
	@Size(max = 2048)
    private String jsonObj;

    /**
     * 网关资金到账时间
     */
    private Date gatewayTime;

}
