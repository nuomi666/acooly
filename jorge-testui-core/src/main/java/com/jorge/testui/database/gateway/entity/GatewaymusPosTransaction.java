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
 * mus_pos_transaction Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:30
 */
@Entity
@Table(name = "mus_pos_transaction")
@Getter
@Setter
public class GatewaymusPosTransaction extends AbstractEntity {

    /**
     * amount
     */
    private Long amount;

    /**
     * biz_order_no
     */
	@Size(max = 64)
    private String bizOrderNo;

    /**
     * ex_data
     */
	@Size(max = 255)
    private String exData;

    /**
     * finish_date
     */
    private Date finishDate;

    /**
     * gid
     */
	@Size(max = 255)
    private String gid;

    /**
     * inst_no
     */
	@Size(max = 255)
    private String instNo;

    /**
     * merch_order_no
     */
	@Size(max = 255)
    private String merchOrderNo;

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
     * notify_status
     */
	@Size(max = 255)
    private String notifyStatus;

    /**
     * notify_time
     */
    private Date notifyTime;

    /**
     * partner_id
     */
	@Size(max = 255)
    private String partnerId;

    /**
     * pay_type
     */
	@Size(max = 255)
    private String payType;

    /**
     * pos_pay_status
     */
	@Size(max = 255)
    private String posPayStatus;

    /**
     * query_date
     */
    private Date queryDate;

    /**
     * ref_number
     */
	@Size(max = 255)
    private String refNumber;

    /**
     * result_code
     */
	@Size(max = 255)
    private String resultCode;

    /**
     * result_message
     */
	@Size(max = 255)
    private String resultMessage;

    /**
     * send_bank_serial
     */
	@Size(max = 255)
    private String sendBankSerial;

    /**
     * suc_amount
     */
    private Long sucAmount;

    /**
     * term_id
     */
	@Size(max = 255)
    private String termId;

    /**
     * trade_type
     */
	@Size(max = 255)
    private String tradeType;

    /**
     * trans_time
     */
    private Date transTime;

    /**
     * posting_flag
     */
    @Size(max = 32)
    private String postingFlag;

}
