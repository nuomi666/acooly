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
 * mus_pab_transfer_notice Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:30
 */
@Entity
@Table(name = "mus_pab_transfer_notice")
@Getter
@Setter
public class GatewaymusPabTransferNotice extends AbstractEntity {

    /**
     * bank_falg
     */
	@Size(max = 255)
    private String bankFalg;

    /**
     * bank_remark
     */
	@Size(max = 255)
    private String bankRemark;

    /**
     * check_order_no
     */
	@Size(max = 255)
    private String checkOrderNo;

    /**
     * check_status
     */
	@Size(max = 255)
    private String checkStatus;

    /**
     * in_bank_name
     */
	@Size(max = 255)
    private String inBankName;

    /**
     * in_bank_no
     */
	@Size(max = 255)
    private String inBankNo;

    /**
     * in_master_accname
     */
	@Size(max = 255)
    private String inMasterAccname;

    /**
     * in_master_accno
     */
	@Size(max = 255)
    private String inMasterAccno;

    /**
     * in_sub_accname
     */
	@Size(max = 255)
    private String inSubAccname;

    /**
     * in_sub_accno
     */
	@Size(max = 255)
    private String inSubAccno;

    /**
     * loan_type
     */
	@Size(max = 255)
    private String loanType;

    /**
     * notify_inter_status
     */
	@Size(max = 255)
    private String notifyInterStatus;

    /**
     * out_accout_name
     */
	@Size(max = 255)
    private String outAccoutName;

    /**
     * out_bank_name
     */
	@Size(max = 255)
    private String outBankName;

    /**
     * out_bank_no
     */
	@Size(max = 255)
    private String outBankNo;

    /**
     * out_card_num
     */
	@Size(max = 255)
    private String outCardNum;

    /**
     * qryf_seqno
     */
	@Size(max = 255)
    private String qryfSeqno;

    /**
     * serial_num
     */
	@Size(max = 255)
    private String serialNum;

    /**
     * sub_account_type
     */
	@Size(max = 255)
    private String subAccountType;

    /**
     * sub_amount
     */
    private Long subAmount;

    /**
     * trade_order_no
     */
	@Size(max = 255)
    private String tradeOrderNo;

    /**
     * transaction_amount
     */
    private Long transactionAmount;

    /**
     * transaction_date
     */
	@Size(max = 255)
    private String transactionDate;

    /**
     * transaction_datetime
     */
	@Size(max = 255)
    private String transactionDatetime;

    /**
     * transaction_note
     */
	@Size(max = 255)
    private String transactionNote;

    /**
     * transaction_type
     */
	@Size(max = 255)
    private String transactionType;

    /**
     * transfer_mess
     */
	@Size(max = 255)
    private String transferMess;

    /**
     * transfer_status
     */
	@Size(max = 255)
    private String transferStatus;

    /**
     * notify_message
     */
	@Size(max = 100000)
    private String notifyMessage;

}
