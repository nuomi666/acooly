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
 * 交易订单记录 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:33
 */
@Entity
@Getter
@Setter
public class FundDataSyn extends AbstractEntity {
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
    @NotEmpty
    @Size(max = 64)
    private String payOrderNo;

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
     *  是否收费 CHARGE_NOT；CHARGE_SUCCESS；CHARGE_FAIL
     */
    @Size(max = 64)
    private String isCharge;

}
