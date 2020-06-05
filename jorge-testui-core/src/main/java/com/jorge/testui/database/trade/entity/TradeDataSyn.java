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
 * 交易订单记录 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:33
 */
@Entity
@Getter
@Setter
public class TradeDataSyn extends AbstractEntity {

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
     * 付款类型
     */
    @Size(max = 64)
    private String type;

    /**
     * 状态
     */
    @NotEmpty
    @Size(max = 64)
    private String status;


    /**
     * 清分类型
     */
    @Size(max = 64)
    private String profitType;

    /**
     * 清分状态
     */
    @Size(max = 64)
    private String profitStatus;

    /**
     * 对账状态
     */
    @Size(max = 64)
    private String reconStatus;


    /**
     * clear_status
     */
    @Size(max = 32)
    private String clearStatus;


    /**
     *流程节点
     */
    String chargeType;
}
