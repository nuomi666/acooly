/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-02-19
*/
package com.jorge.testui.database.bill.entity;


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
 * 交易订单记录 Entity
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
@Entity
@Table(name = "tra_trade")
@Getter
@Setter
public class TraTrade extends AbstractEntity {

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
     * 业务场景
     */
	@Size(max = 64)
    private String businessScene;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 自动关闭时间
     */
    private Date closeTime;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 交易手续费
     */
    private Long clearAmount;

    /**
     * 分润金额
     */
	@NotNull
    private Long profitAmount;

    /**
     * 付款类型
     */
	@Size(max = 64)
    private String type;

    /**
     * 状态
     */
	@Size(max = 64)
    private String status;

    /**
     * 卖家id
     */
	@Size(max = 64)
    private String sellerUserNo;

    /**
     * 卖家用户名
     */
	@Size(max = 64)
    private String sellerUserName;

    /**
     * 卖家账号
     */
	@Size(max = 64)
    private String sellerAccountNo;

    /**
     * 买家Id
     */
	@Size(max = 32)
    private String buyerUserNo;

    /**
     * 买家用户名
     */
	@Size(max = 32)
    private String buyerUserName;

    /**
     * 付款方会员id
     */
	@Size(max = 32)
    private String payerUserNo;

    /**
     * 付款人用户名
     */
	@Size(max = 32)
    private String payerUserName;

    /**
     * 付款方账户id
     */
	@Size(max = 32)
    private String payerAccountNo;

    /**
     * 收款人ID
     */
	@Size(max = 32)
    private String payeeUserNo;

    /**
     * 收款方会员id
     */
	@Size(max = 32)
    private String payeeUserName;

    /**
     * 收款方账户id
     */
	@Size(max = 32)
    private String payeeAccountNo;

    /**
     * 真实收款用户号
     */
	@Size(max = 32)
    private String realPayeeUserNo;

    /**
     * 真实收款用户名
     */
	@Size(max = 32)
    private String realPayeeUserName;

    /**
     * 真实收款账户号
     */
	@Size(max = 32)
    private String realPayeeAccountNo;

    /**
     * 清分类型
     */
	@Size(max = 64)
    private String profitType;

    /**
     * 清分状态
     */
	@Size(max = 64)
    private String profitStatus;

    /**
     * 已退款金额
     */
    private Long refundAmount;

    /**
     * 已手续费金额
     */
    private Long refundFeeAmount;

    /**
     * 已手续费金额
     */
    private Long refundBankFeeAmount;

    /**
     * 对账状态
     */
	@Size(max = 64)
    private String reconStatus;

    /**
     * 过账状态
     */
	@Size(max = 64)
    private String postingFlag;

    /**
     * 交易名称
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeName;

    /**
     * 交易备注
     */
	@Size(max = 64)
    private String tradeMemo;

    /**
     * 用户id
     */
	@Size(max = 64)
    private String userIp;

    /**
     * 交易MAC地址
     */
	@Size(max = 64)
    private String macAddress;

    /**
     * 所属商户
     */
	@NotEmpty
	@Size(max = 32)
    private String partnerId;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * clear_status
     */
	@Size(max = 32)
    private String clearStatus;

    /**
     * pos_batch_no
     */
	@Size(max = 32)
    private String posBatchNo;

    /**
     * pos_client_no
     */
	@Size(max = 32)
    private String posClientNo;

    /**
     * pos_merchant_no
     */
	@Size(max = 32)
    private String posMerchantNo;

    /**
     * 商户摆拍二维码
     */
	@Size(max = 32)
    private String merchTwoNumCode;

    /**
     * 异步通知gid
     */
	@Size(max = 64)
    private String notifyGid;

    /**
     * 代理商id
     */
    private Long agentId;

    /**
     * 业务员id
     */
    private Long salesmanId;

    /**
     * 平台类型
     */
	@Size(max = 32)
    private String platformType;

    /**
     * 交易来源
     */
	@Size(max = 20)
    private String tradeSource;

    /**
     * 支付渠道
     */
	@Size(max = 50)
    private String serviceBankType;

    /**
     * 收费完成时间
     */
    private Date clearFinishTime;

    /**
     * 渠道成本
     */
    private Long bankFee;

    /**
     * 手续费支付角色
     */
	@Size(max = 20)
    private String feePayRole;

    /**
     * 手续费支付会员id
     */
	@Size(max = 32)
    private String feePayUserNo;

    /**
     * 账期
     */
	@Size(max = 12)
    private String periodNo;

}
