/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-17
*/
package com.jorge.testui.database.profit.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * profit_main_refund_log Entity
 *
 * @author mufanglin
 * Date: 2019-12-17 16:50:59
 */
@Entity
@Table(name = "profit_main_refund_log")
@Getter
@Setter
public class ProfitMainRefundLog extends AbstractEntity {

    /**
     * gid
     */
	@NotEmpty
	@Size(max = 64)
    private String gid;

    /**
     * 上层流水号
     */
	@NotEmpty
	@Size(max = 64)
    private String outBizNo;

    /**
     * 原始流水号
     */
	@Size(max = 64)
    private String originalOutBizNo;

    /**
     * 商户ID
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * 外部订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 清分主订单流水号
     */
	@NotEmpty
	@Size(max = 32)
    private String profitNo;

    /**
     * 清分子订单流水号
     */
	@NotEmpty
	@Size(max = 32)
    private String profitsNo;

    /**
     * 清分状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * refund_amount
     */
	@NotNull
    private Long refundAmount;

    /**
     * 交易日期
     */
	@NotNull
    private Date tradeDate;

    /**
     * 交易类型
     */
	@Size(max = 128)
    private String tradeType;

    /**
     * 规则扩展信息
     */
	@Size(max = 100000)
    private String extendsPro;

    /**
     * memo
     */
	@Size(max = 255)
    private String memo;

}
