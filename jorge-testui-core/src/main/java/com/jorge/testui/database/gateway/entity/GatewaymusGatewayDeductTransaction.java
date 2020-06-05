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
 * mus_gateway_deduct_transaction Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:29
 */
@Entity
@Table(name = "mus_gateway_deduct_transaction")
@Getter
@Setter
public class GatewaymusGatewayDeductTransaction extends AbstractEntity {

    /**
     * amount
     */
    private Long amount;

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
     * bank_settle_no
     */
	@Size(max = 255)
    private String bankSettleNo;

    /**
     * batch_no
     */
	@Size(max = 255)
    private String batchNo;

    /**
     * business_code
     */
	@Size(max = 255)
    private String businessCode;

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
     * link_no
     */
	@Size(max = 255)
    private String linkNo;

    /**
     * merch_order_no
     */
	@Size(max = 255)
    private String merchOrderNo;

    /**
     * mobile_no
     */
	@Size(max = 255)
    private String mobileNo;

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
     * pay_account_name
     */
	@Size(max = 255)
    private String payAccountName;

    /**
     * pay_agr_index
     */
	@Size(max = 255)
    private String payAgrIndex;

    /**
     * pay_agr_no
     */
	@Size(max = 255)
    private String payAgrNo;

    /**
     * pay_bank_account
     */
	@Size(max = 255)
    private String payBankAccount;

    /**
     * pay_bank_city
     */
	@Size(max = 255)
    private String payBankCity;

    /**
     * pay_bank_id
     */
	@Size(max = 255)
    private String payBankId;

    /**
     * pay_bank_lasalle
     */
	@Size(max = 255)
    private String payBankLasalle;

    /**
     * pay_bank_name
     */
	@Size(max = 255)
    private String payBankName;

    /**
     * pay_bank_province
     */
	@Size(max = 255)
    private String payBankProvince;

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
     * remark
     */
	@Size(max = 255)
    private String remark;

    /**
     * security_index
     */
	@Size(max = 255)
    private String securityIndex;

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
     * type
     */
	@Size(max = 255)
    private String type;

    /**
     * user_cert_no
     */
	@Size(max = 255)
    private String userCertNo;

    /**
     * user_cert_type
     */
	@Size(max = 255)
    private String userCertType;

    /**
     * user_id
     */
	@Size(max = 255)
    private String userId;

    /**
     * posting_flag
     */
    @Size(max = 32)
	private String postingFlag;

    /**
     * merch_id
     */
    @Size(max = 255)
    private String merchId;


}
