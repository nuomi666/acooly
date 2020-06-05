/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-01-08
*/
package com.jorge.testui.database.gateway.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 签约流水 Entity
 *
 * @author mufanglin
 * @date 2020-01-08 09:41:20
 */
@Entity
@Table(name = "mus_sign_transaction")
@Getter
@Setter
public class MusSignTransaction extends AbstractEntity {

    /**
     * amount
     */
    private Long amount;

    /**
     * bank_date
     */
    private Date bankDate;

    /**
     * bank_notify_ip
     */
	@Size(max = 255)
    private String bankNotifyIp;

    /**
     * bank_serial_no
     */
	@Size(max = 255)
    private String bankSerialNo;

    /**
     * business_code
     */
	@Size(max = 255)
    private String businessCode;

    /**
     * currency
     */
	@Size(max = 255)
    private String currency;

    /**
     * extra_info_json
     */
	@Size(max = 255)
    private String extraInfoJson;

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
     * merchant_no
     */
	@Size(max = 255)
    private String merchantNo;

    /**
     * notify_front_url
     */
	@Size(max = 255)
    private String notifyFrontUrl;

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
     * account_name
     */
	@Size(max = 64)
    private String accountName;

    /**
     * account_no
     */
	@Size(max = 64)
    private String accountNo;

    /**
     * partner_id
     */
	@Size(max = 255)
    private String partnerId;

    /**
     * card_type
     */
	@Size(max = 32)
    private String cardType;

    /**
     * cert_type
     */
	@Size(max = 32)
    private String certType;

    /**
     * cert_no
     */
	@Size(max = 32)
    private String certNo;

    /**
     * phone_no
     */
	@Size(max = 255)
    private String phoneNo;

    /**
     * bank_code
     */
	@Size(max = 64)
    private String bankCode;

    /**
     * bank_name
     */
	@Size(max = 255)
    private String bankName;

    /**
     * agreement_no
     */
	@Size(max = 255)
    private String agreementNo;

    /**
     * query_bank_count
     */
    private Integer queryBankCount;

    /**
     * sign_serial_no
     */
	@Size(max = 255)
    private String signSerialNo;

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
     * user_id
     */
	@Size(max = 255)
    private String userId;

    /**
     * merch_id
     */
	@Size(max = 255)
    private String merchId;

    /**
     * posting_flag
     */
	@Size(max = 32)
    private String postingFlag;

}
