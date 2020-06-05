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
 * 对账结果记录表 Entity
 *
 * @author mufanglin
 * Date: 2019-12-05 09:52:02
 */
@Entity
@Table(name = "recon_recon_result")
@Getter
@Setter
public class ReconReconResult extends AbstractEntity {

    /**
     * period_no
     */
	@Size(max = 32)
    private String periodNo;

    /**
     * gid
     */
	@Size(max = 64)
    private String gid;

    /**
     * biz_order_no
     */
	@Size(max = 64)
    private String bizOrderNo;

    /**
     * partner_id
     */
	@Size(max = 64)
    private String partnerId;

    /**
     * merchant_no
     */
	@Size(max = 64)
    private String merchantNo;

    /**
     * send_bank_serial_no
     */
	@Size(max = 64)
    private String sendBankSerialNo;

    /**
     * channel_order_no
     */
	@Size(max = 64)
    private String channelOrderNo;

    /**
     * amount_channel
     */
    private Long amountChannel;

    /**
     * amount_gateway
     */
    private Long amountGateway;

    /**
     * finish_time
     */
    private Date finishTime;

    /**
     * memo
     */
	@Size(max = 255)
    private String memo;

    /**
     * status
     */
	@Size(max = 64)
    private String status;

    /**
     * trade_type
     */
	@Size(max = 64)
    private String tradeType;

    /**
     * charge
     */
    private Long charge;

    /**
     * 渠道类型
     */
	@Size(max = 64)
    private String channelType;

    /**
     * profit_status
     */
	@Size(max = 64)
    private String profitStatus;

    /**
     * profit_memo
     */
	@Size(max = 255)
    private String profitMemo;

}
