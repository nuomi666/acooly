/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-05
 */
package com.jorge.testui.database.bill.entity;


import com.acooly.core.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 每日对账结果 Entity
 *
 * @author mufanglin
 * Date: 2019-12-05 09:52:01
 */
@Entity
@Table(name = "recon_period")
@Getter
@Setter
public class ReconPeriod extends AbstractEntity {

    /**
     * 账期
     */
    @Size(max = 32)
    private String periodNo;

    /**
     * 对账状态
     */
    @Size(max = 64)
    private String status;

    /**
     * 对账备注
     */
    @Size(max = 255)
    private String memo;

    /**
     * 渠道数据状态
     */
    @NotEmpty
    @Size(max = 64)
    private String channelDataStatus;

    /**
     * 渠道数据备注
     */
    @Size(max = 255)
    private String channelDataMemo;

    /**
     * 网关数据状态
     */
    @NotEmpty
    @Size(max = 64)
    private String gatewayDataStatus;

    /**
     * 网关记录条数
     */
    private Long gatewayDateNo;

    /**
     * 网关数据备注
     */
    @Size(max = 255)
    private String gatewayDataMemo;

    /**
     * 成功条数
     */
    @NotNull
    private Long successNo;

    /**
     * 多余条数
     */
    @NotNull
    private Long excessNo;

    /**
     * 退款状态
     */
    @Size(max = 64)
    private String refundStatus;

    /**
     * 退款备注
     */
    @Size(max = 255)
    private String refundMemo;

    /**
     * 退款条数
     */
    @NotNull
    private Long refundNo;

    /**
     * 失败条数
     */
    @NotNull
    private Long failNo;

    /**
     * 清分状态
     */
    @NotEmpty
    @Size(max = 64)
    private String profitStatus;

    /**
     * 清分备注
     */
    @Size(max = 255)
    private String profitMemo;

    /**
     * 备注
     */
    @Size(max = 255)
    private String commemts;

}
