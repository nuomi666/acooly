/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.trade.entity;


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
 * 通用交易流程 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:32
 */
@Entity
@Table(name = "tra_payment_flow")
@Getter
@Setter
public class TradetraPaymentFlow extends AbstractEntity {

    /**
     * gid
     */
	@NotEmpty
	@Size(max = 64)
    private String gid;

    /**
     * 商户订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 交易订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeNo;

    /**
     * 支付订单号
     */
	@Size(max = 64)
    private String payOrderNo;

    /**
     * 业务订单号
     */
	@Size(max = 64)
    private String bizOrderNo;

    /**
     * 流程节点
     */
	@Size(max = 32)
    private String flowNode;

    /**
     * 状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * 重复支付
     */
	@Size(max = 32)
    private String repeatPay;

    /**
     * 备注
     */
	@Size(max = 64)
    private String memo;

    /**
     * 所属商户
     */
	@Size(max = 32)
    private String partnerId;

}
