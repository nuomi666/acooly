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
 * pos交易订单数据 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:34
 */
@Entity
@Table(name = "tra_trade_pos")
@Getter
@Setter
public class TradetraTradePos extends AbstractEntity {

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
     * 交易金额
     */
    private Long amount;

    /**
     * POS商户号
     */
	@Size(max = 64)
    private String posMerchantNo;

    /**
     * 业务平台传入的POS终端号
     */
	@Size(max = 64)
    private String partnerPosClientNo;

    /**
     * POS终端号
     */
	@Size(max = 64)
    private String posClientNo;

    /**
     * POS批次号
     */
	@Size(max = 64)
    private String posBatchNo;

    /**
     * POS流水号
     */
	@Size(max = 64)
    private String posTransactionNo;

    /**
     * 银行名称
     */
	@Size(max = 32)
    private String bankName;

    /**
     * 银行卡号
     */
	@Size(max = 32)
    private String bankCardNo;

    /**
     * 银行卡类型
     */
	@Size(max = 32)
    private String bankCardType;

    /**
     * 店铺名称
     */
	@Size(max = 64)
    private String shopName;

    /**
     * province
     */
	@Size(max = 32)
    private String province;

    /**
     * 市
     */
	@Size(max = 32)
    private String city;

    /**
     * 县
     */
	@Size(max = 32)
    private String area;

    /**
     * otherParams
     */
	@Size(max = 512)
    private String otherparams;

}
