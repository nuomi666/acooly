/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.entity;


import com.acooly.core.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 交易退款 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:35
 */
@Entity
@Table(name = "tra_trade_refund")
@Getter
@Setter
public class TradetraTradeRefund extends AbstractEntity {

    /**
     * gid
     */
    @NotEmpty
    @Size(max = 64)
    private String gid;

    /**
     * 商户退款订单号
     */
    @NotEmpty
    @Size(max = 64)
    private String refundMerchOrderNo;

    /**
     * 商户订单号
     */
    @NotEmpty
    @Size(max = 64)
    private String origMerchOrderNo;

    /**
     * 交易订单号
     */
    @NotEmpty
    @Size(max = 64)
    private String origTradeNo;

    /**
     * 支付订单号
     */
    @Size(max = 64)
    private String origPayOrderNo;

    /**
     * 原交易业务订单号
     */
    @Size(max = 255)
    private String origBizOrderNo;

    /**
     * 类型
     */
    @Size(max = 32)
    private String type;

    /**
     * 交易金额（原订单金额）
     */
    private Long amount;

    /**
     * 退款金额（本次退款金额）
     */
    private Long refundAmount;

    /**
     * 退款手续费金额（本次退款金额）
     */
    private Long refundFeeAmount;

    /**
     * 已退渠道手续费金额
     */
    private Long refundBankFeeAmount;
    /**
     * 退款类型
     */
    private String refundType;

    /**
     * 对账状态
     */
    private String reconStatus;

    /**
     * 付款用户号
     */
    @Size(max = 64)
    private String payerUserNo;

    /**
     * 付款人账户
     */
    @Size(max = 64)
    private String payerAccountNo;

    /**
     * 收款人用户号
     */
    @Size(max = 64)
    private String payeeUserNo;

    /**
     * 收款人账户
     */
    @Size(max = 64)
    private String payeeAccountNo;

    /**
     * 退款状态
     */
    @Size(max = 32)
    private String status;

    /**
     * 退款原因
     */
    @Size(max = 200)
    private String refundReason;

    /**
     * 备注
     */
    @Size(max = 200)
    private String memo;

    /**
     * 所属商户
     */
    @Size(max = 32)
    private String partnerId;

}
