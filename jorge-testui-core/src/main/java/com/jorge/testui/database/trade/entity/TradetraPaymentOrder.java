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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 通用交易支付订单（请求流水记录） Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:33
 */
@Entity
@Table(name = "tra_payment_order")
@Getter
@Setter
public class TradetraPaymentOrder extends AbstractEntity {

    /**
     * gid
     */
    @NotEmpty
    @Size(max = 64)
    private String gid;

    /**
     * 交易订单号
     */
    @NotEmpty
    @Size(max = 64)
    private String tradeNo;

    /**
     * 商户订单号
     */
    @NotEmpty
    @Size(max = 64)
    private String merchOrderNo;

    /**
     * 业务订单号
     */
    @Size(max = 64)
    private String bizOrderNo;

    /**
     * 修改时间
     */
    @Size(max = 64)
    private Date updateTime;

    /**
     * 支付节点
     */
    @Size(max = 40)
    private String flowNode;

    /**
     * 交易金额
     */
    @NotNull
    private Long amount;

    /**
     * 状态
     */
    @NotEmpty
    @Size(max = 32)
    private String status;

    /**
     * 付款人用户号
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
     * 清分类型
     */
    @Size(max = 64)
    private String profitType;

    /**
     * 交易备注
     */
    @Size(max = 512)
    private String tradeMemo;

    /**
     * 备注
     */
    @Size(max = 512)
    private String memo;

    /**
     * 所属商户
     */
    @Size(max = 32)
    private String partnerId;

    /**
     * pay_order_no
     */
    @Size(max = 64)
    private String payOrderNo;

    /**
     * type
     */
    @Size(max = 32)
    private String type;

    /**
     * service_bank_mode
     */
    @Size(max = 40)
    private String serviceBankMode;

    /**
     * service_bank_type
     */
    @Size(max = 40)
    private String serviceBankType;

    /**
     * bank_fee
     */
    private Integer bankFee;

    /**
     * recon_status
     */
    @Size(max = 64)
    private String reconStatus;

    /**
     * real_payee_account_no
     */
    @Size(max = 64)
    private String realPayeeAccountNo;

    /**
     * real_payee_user_no
     */
    @Size(max = 64)
    private String realPayeeUserNo;

    /**
     * account_period_no
     */
    @Size(max = 20)
    private String accountPeriodNo;

}
