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
 * 网关记录表 Entity
 *
 * @author mufanglin
 * Date: 2019-12-05 09:52:01
 */
@Entity
@Table(name = "recon_gateway_record")
@Getter
@Setter
public class ReconGatewayRecord extends AbstractEntity {

    /**
     * 账期
     */
	@Size(max = 12)
    private String periodNo;

    /**
     * GID
     */
	@Size(max = 64)
    private String gid;

    /**
     * 业务流水号
     */
	@Size(max = 64)
    private String bizOrderNo;

    /**
     * 商户号
     */
	@Size(max = 64)
    private String partnerId;

    /**
     * 外部商户号
     */
	@Size(max = 64)
    private String merchantNo;

    /**
     * 发送银行流水号
     */
	@Size(max = 64)
    private String sendBankOrderNo;

    /**
     * 渠道流水号
     */
	@Size(max = 64)
    private String channelOrderNo;

    /**
     * 订单金额
     */
    private Long amount;

    /**
     * 交易金额
     */
    private Long amountIn;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 收支方向
     */
	@Size(max = 64)
    private String changeDirection;

    /**
     * 渠道API
     */
	@Size(max = 64)
    private String channelApi;

    /**
     * 网关备注
     */
	@Size(max = 255)
    private String memo;

    /**
     * 订单完成时间
     */
    private Date orderTime;

    /**
     * 交易类型
     */
	@Size(max = 64)
    private String tradeOrderType;

    /**
     * 交易状态
     */
	@Size(max = 64)
    private String tradeStatus;

    /**
     * 对账状态
     */
	@Size(max = 64)
    private String status;

    /**
     * 备注
     */
	@Size(max = 255)
    private String comments;

}
