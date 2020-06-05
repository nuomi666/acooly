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
 * 运营商表账户变动表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:55
 */
@Entity
@Table(name = "act_account_operator_change")
@Getter
@Setter
public class PaycoreactAccountOperatorChange extends AbstractEntity {

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
     * 变动金额
     */
    private Long amount;

    /**
     * 变动后余额
     */
    private Long balance;

    /**
     * 变动类型
     */
	@Size(max = 16)
    private String orderType;

    /**
     * 变动方向
     */
	@Size(max = 4)
    private String changeDirection;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * 网关资金到账时间
     */
    private Date gatewayTime;

}
