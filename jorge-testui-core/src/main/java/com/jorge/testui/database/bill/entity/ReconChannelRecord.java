/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-05
*/
package com.jorge.testui.database.bill.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 渠道记录表 Entity
 *
 * @author mufanglin
 * Date: 2019-12-05 09:52:01
 */
@Entity
@Table(name = "recon_channel_record")
@Getter
@Setter
public class ReconChannelRecord extends AbstractEntity {

    /**
     * 账期
     */
	@Size(max = 12)
    private String periodNo;

    /**
     * 渠道类型
     */
	@Size(max = 64)
    private String channelType;

    /**
     * 商户号
     */
	@Size(max = 64)
    private String partnerId;

    /**
     * 发送渠道流水号
     */
	@Size(max = 64)
    private String sendBankOrderNo;

    /**
     * 渠道订单号
     */
	@Size(max = 64)
    private String channelOrderNo;

    /**
     * 订单金额
     */
    private Long amount;

    /**
     * 实际交易金额
     */
    private Long amountIn;

    /**
     * 银行划款金额
     */
    private Long amountBank;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 交易前余额
     */
    private Long balanceBefore;

    /**
     * 收支方向
     */
	@Size(max = 64)
    private String changeDirection;

    /**
     * 手续费
     */
    private Long charge;

    /**
     * 渠道备注
     */
	@Size(max = 255)
    private String memo;

    /**
     * 订单完成时间
     */
    private Date orderTime;

    /**
     * 交易状态
     */
	@Size(max = 64)
    private String tradeStatus;

    /**
     * 交易类型
     */
	@Size(max = 64)
    private String tradeType;

    /**
     * 对账状态
     */
	@Size(max = 64)
    private String status;

    /**
     * 对账备注
     */
	@Size(max = 255)
    private String comments;

}
