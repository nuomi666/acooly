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
 * mus_netbank_payment_txn Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:29
 */
@Entity
@Table(name = "mus_netbank_payment_txn")
@Getter
@Setter
public class GatewaymusNetbankPaymentTxn extends AbstractEntity {

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
     * par_merchant_no
     */
	@Size(max = 255)
    private String parMerchantNo;

    /**
     * partner_id
     */
	@Size(max = 255)
    private String partnerId;

    /**
     * pay_account_cust_no
     */
	@Size(max = 255)
    private String payAccountCustNo;

    /**
     * pay_account_name
     */
	@Size(max = 255)
    private String payAccountName;

    /**
     * pay_bank_account
     */
	@Size(max = 255)
    private String payBankAccount;

    /**
     * pay_bank_id
     */
	@Size(max = 255)
    private String payBankId;

    /**
     * pay_serial_no
     */
	@Size(max = 255)
    private String paySerialNo;

    /**
     * pay_user_cert_no
     */
	@Size(max = 255)
    private String payUserCertNo;

    /**
     * pay_user_cert_type
     */
	@Size(max = 255)
    private String payUserCertType;

    /**
     * pay_user_mobile
     */
	@Size(max = 255)
    private String payUserMobile;

    /**
     * query_bank_count
     */
    private Integer queryBankCount;

    /**
     * rec_bank_account
     */
	@Size(max = 255)
    private String recBankAccount;

    /**
     * rec_bank_account_name
     */
	@Size(max = 255)
    private String recBankAccountName;

    /**
     * rec_bank_id
     */
	@Size(max = 255)
    private String recBankId;

    /**
     * rec_bank_name
     */
	@Size(max = 255)
    private String recBankName;

    /**
     * risk_ctrl_index
     */
	@Size(max = 255)
    private String riskCtrlIndex;

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
     * status
     */
	@Size(max = 255)
    private String status;

    /**
     * submit_correct_status
     */
    private Integer submitCorrectStatus;

    /**
     * suc_amount
     */
    private Long sucAmount;

    /**
     * user_end_ip
     */
	@Size(max = 255)
    private String userEndIp;

    /**
     * user_id
     */
	@Size(max = 255)
    private String userId;

    /**
     * valid_date
     */
    private Date validDate;

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
