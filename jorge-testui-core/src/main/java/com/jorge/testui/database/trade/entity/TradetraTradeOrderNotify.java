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
 * 交易系统异步通知 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:34
 */
@Entity
@Table(name = "tra_trade_order_notify")
@Getter
@Setter
public class TradetraTradeOrderNotify extends AbstractEntity {

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
     *  支付交易号
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeNo;

    /**
     * 类型
     */
	@Size(max = 32)
    private String notifyType;

    /**
     * 是否异步通知
     */
	@Size(max = 64)
    private String isNotify;

    /**
     * 异步通知次数
     */
    private Integer notifyNum;

    /**
     * 异步通知gid
     */
	@Size(max = 64)
    private String notifyGid;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

}
