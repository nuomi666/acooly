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
 * mus_withdraw_transaction Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:31
 */
@Entity
@Table(name = "mus_withdraw_transaction")
@Getter
@Setter
public class GatewaymusWithdrawTransaction extends AbstractEntity {

    /**
     * amount
     */
    private Long amount;

    /**
     * bank_card_type
     */
	@Size(max = 255)
    private String bankCardType;

    /**
     * bank_date
     */
    private Date bankDate;

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
     * batch_no
     */
	@Size(max = 255)
    private String batchNo;

    /**
     * extend_param
     */
	@Size(max = 255)
    private String extendParam;

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
     * memo
     */
	@Size(max = 255)
    private String memo;

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
     * operation_id
     */
    private Long operationId;

    /**
     * operation_mobile_no
     */
	@Size(max = 255)
    private String operationMobileNo;

    /**
     * operation_real_name
     */
	@Size(max = 255)
    private String operationRealName;

    /**
     * partner_id
     */
	@Size(max = 255)
    private String partnerId;

    /**
     * pay_account_name
     */
	@Size(max = 255)
    private String payAccountName;

    /**
     * pay_account_no
     */
	@Size(max = 255)
    private String payAccountNo;

    /**
     * pay_bank_id
     */
	@Size(max = 255)
    private String payBankId;

    /**
     * pay_bank_name
     */
	@Size(max = 255)
    private String payBankName;

    /**
     * public_tag
     */
	@Size(max = 255)
    private String publicTag;

    /**
     * rec_account_name
     */
	@Size(max = 255)
    private String recAccountName;

    /**
     * rec_account_no
     */
	@Size(max = 255)
    private String recAccountNo;

    /**
     * rec_bank_id
     */
	@Size(max = 255)
    private String recBankId;

    /**
     * rec_bank_lasalle
     */
	@Size(max = 255)
    private String recBankLasalle;

    /**
     * rec_bank_name
     */
	@Size(max = 255)
    private String recBankName;

    /**
     * rec_city
     */
	@Size(max = 255)
    private String recCity;

    /**
     * rec_province
     */
	@Size(max = 255)
    private String recProvince;

    /**
     * send_bank_serial
     */
	@Size(max = 255)
    private String sendBankSerial;

    /**
     * settle_date
     */
    private Date settleDate;

    /**
     * settle_serial_no
     */
	@Size(max = 255)
    private String settleSerialNo;

    /**
     * status
     */
	@Size(max = 255)
    private String status;

    /**
     * suc_amount
     */
    private Long sucAmount;

    /**
     * user_id
     */
	@Size(max = 255)
    private String userId;

    /**
     * withdraw_flag
     */
	@Size(max = 255)
    private String withdrawFlag;

    /**
     * posting_flag
     */
    @Size(max = 32)
    private String postingFlag;

}
