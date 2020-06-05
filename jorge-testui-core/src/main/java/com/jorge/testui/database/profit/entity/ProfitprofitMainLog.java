/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.entity;


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
 * profit_main_log Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:05:03
 */
@Entity
@Table(name = "profit_main_log")
@Getter
@Setter
public class ProfitprofitMainLog extends AbstractEntity {

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
     * 用户ID
     */
    @Size(max = 32)
    private String userId;

    /**
     * 上层流水号
     */
    @NotEmpty
    @Size(max = 64)
    private String outBizNo;

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
     * gid
     */
    @NotEmpty
    @Size(max = 64)
    private String gid;

    /**
     * trade_amount
     */
    @NotNull
    private Long tradeAmount;

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


    private Long refundAmount = 0l;

}
