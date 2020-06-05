/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.gateway.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * mus_deposit_back_transaction Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:28
 */
@Entity
@Table(name = "mus_deposit_back_transaction")
@Getter
@Setter
public class GatewaymusDepositBackTransaction extends AbstractEntity {

    /**
     * amount
     */
    private Long amount;

    /**
     * bank_return_time
     */
    private Date bankReturnTime;

    /**
     * bank_serial_no
     */
	@Size(max = 255)
    private String bankSerialNo;

    /**
     * deposit_back_time
     */
    private Date depositBackTime;

    /**
     * deposit_serial_no
     */
	@Size(max = 255)
    private String depositSerialNo;

    /**
     * deposit_time
     */
	@Size(max = 255)
    private String depositTime;

    /**
     * gid
     */
	@Size(max = 255)
    private String gid;

    /**
     * inst_channel_api
     */
	@Size(max = 255)
    private String instChannelApi;

    /**
     * merch_order_no
     */
	@Size(max = 255)
    private String merchOrderNo;

    /**
     * notify_group
     */
	@Size(max = 255)
    private String notifyGroup;

    /**
     * notify_inter_status
     */
	@Size(max = 255)
    private String notifyInterStatus;

    /**
     * notify_message
     */
	@Size(max = 100000)
    private String notifyMessage;

    /**
     * notify_send_count
     */
    private Integer notifySendCount;

    /**
     * notify_time
     */
    private Date notifyTime;

    /**
     * notify_version
     */
	@Size(max = 255)
    private String notifyVersion;

    /**
     * old_biz_order_no
     */
	@Size(max = 255)
    private String oldBizOrderNo;

    /**
     * partner_id
     */
	@Size(max = 255)
    private String partnerId;

    /**
     * pay_account_no
     */
	@Size(max = 255)
    private String payAccountNo;

    /**
     * refund_reason
     */
	@Size(max = 255)
    private String refundReason;

    /**
     * result_code
     */
	@Size(max = 255)
    private String resultCode;

    /**
     * send_bank_serial
     */
	@Size(max = 255)
    private String sendBankSerial;

    /**
     * status
     */
	@Size(max = 255)
    private String status;

    /**
     * posting_flag
     */
    @Size(max = 32)
    private String postingFlag;

}
