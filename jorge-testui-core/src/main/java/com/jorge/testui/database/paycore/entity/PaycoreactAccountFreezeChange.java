/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.paycore.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 冻结账户变动表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:54
 */
@Entity
@Table(name = "act_account_freeze_change")
@Getter
@Setter
public class PaycoreactAccountFreezeChange extends AbstractEntity {

    /**
     * 全站统一订单号
     */
	@Size(max = 64)
    private String gid;

    /**
     * 外部商户订单号
     */
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 支付订单号
     */
	@Size(max = 32)
    private String bizOrderNo;

    /**
     * 接入商ID
     */
	@Size(max = 32)
    private String partnerId;

    /**
     * 交易类型
     */
	@Size(max = 32)
    private String tradeType;

    /**
     * 冻结类型
     */
	@Size(max = 32)
    private String freezeType;

    /**
     * 用户编码
     */
	@Size(max = 32)
    private String userNo;

    /**
     * 账户号
     */
	@Size(max = 32)
    private String accountNo;

    /**
     * 变动方向
     */
	@Size(max = 4)
    private String changeDirection;

    /**
     * 交易金额
     */
    private Long freezeAmount;

    /**
     * 交易后余额
     */
    private Long freezeBalance;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * 剩余未解冻金额
     */
    private Long freezeLeave;

}
