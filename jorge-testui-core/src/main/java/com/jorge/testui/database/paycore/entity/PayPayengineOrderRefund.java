/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-19
*/
package com.jorge.testui.database.paycore.entity;


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
 * 退款信息表(主表) Entity
 *
 * @author mufanglin
 * Date: 2019-12-19 17:40:43
 */
@Entity
@Table(name = "pay_payengine_order_refund")
@Getter
@Setter
public class PayPayengineOrderRefund extends AbstractEntity {

    /**
     * 全站统一订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String gid;

    /**
     * 外部商户订单号
     */
	@NotEmpty
	@Size(max = 64)
    private String merchantNo;

    /**
     * 接入商ID
     */
	@NotEmpty
	@Size(max = 64)
    private String partnerId;

    /**
     * 交易类型
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeType;

    /**
     * 申请网关流水号
     */
	@NotEmpty
	@Size(max = 64)
    private String orderNo;

    /**
     * 原支付交易订单号
     */
	@Size(max = 64)
    private String orilTradeNo;

    /**
     * 申请退款流程第一步的流水号（用于试算手续费）
     */
	@Size(max = 64)
    private String applyRefundOrderNo;

    /**
     * 二次申请网关流水号
     */
	@NotEmpty
	@Size(max = 64)
    private String aggenOrderNo;

    /**
     * 原充值流水号
     */
	@Size(max = 64)
    private String depositOrderNo;

    /**
     * 退款范畴，全额，部分
     */
	@NotEmpty
	@Size(max = 64)
    private String refundScope;

    /**
     * 是否为最后一笔退款
     */
	@NotEmpty
	@Size(max = 64)
    private String isLastOperate;

    /**
     * 退款类型，撤销，退款，手续费退款，平台商手续费退款
     */
	@NotEmpty
	@Size(max = 64)
    private String refundType;

    /**
     * 执行状态
     */
	@NotEmpty
	@Size(max = 64)
    private String refundStatus;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 实际到账金额
     */
    private Long amountIn;

    /**
     * 付款类型
     */
	@Size(max = 64)
    private String payType;

    /**
     * 退货原因
     */
	@Size(max = 255)
    private String depositBackReason;

    /**
     * 备注
     */
	@Size(max = 255)
    private String memo;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 银行回执时间
     */
    private Date bankTime;

    /**
     * 通知其他系统状态
     */
	@Size(max = 32)
    private String notifyStatus;

    /**
     * 通知上层系统的次数
     */
    private Integer notifyNum;

    /**
     * 通知上层系统备注
     */
	@Size(max = 256)
    private String notifyMsg;

    /**
     * 会员ID
     */
	@Size(max = 64)
    private String userId;

    /**
     * 会员账务号
     */
	@Size(max = 64)
    private String accountNo;

    /**
     * 银行会员账务号
     */
	@Size(max = 64)
    private String bankAccountNo;

    /**
     * 会员姓名
     */
	@Size(max = 64)
    private String userName;

    /**
     * 对手方ID
     */
	@Size(max = 64)
    private String payeeUserId;

    /**
     * 对手方账务号
     */
	@Size(max = 64)
    private String payeeUserAccountNo;

    /**
     * 对手方账务号
     */
	@Size(max = 64)
    private String bankPayeeUserAccountNo;

    /**
     * 对手方会员姓名
     */
	@Size(max = 64)
    private String payeeUserName;

    /**
     * 渠道
     */
	@Size(max = 64)
    private String serviceBankType;

}
