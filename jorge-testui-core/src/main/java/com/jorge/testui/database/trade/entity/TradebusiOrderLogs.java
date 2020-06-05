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
 * 业务管控订单信息 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:31
 */
@Entity
@Table(name = "busi_order_logs")
@Getter
@Setter
public class TradebusiOrderLogs extends AbstractEntity {

    /**
     * 用户号
     */
	@NotEmpty
	@Size(max = 20)
    private String userNo;

    /**
     * 交易类型
     */
	@Size(max = 32)
    private String tradeType;

    /**
     * 交易支付订单号
     */
	@Size(max = 64)
    private String tradeNo;

    /**
     * 商户订单号
     */
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 状态
     */
	@Size(max = 20)
    private String orderStatus;

    /**
     * 交易类型
     */
	@Size(max = 32)
    private String type;

}
