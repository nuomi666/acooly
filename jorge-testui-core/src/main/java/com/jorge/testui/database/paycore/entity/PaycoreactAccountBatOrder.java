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
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * 账务系统批量订单表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:53
 */
@Entity
@Table(name = "act_account_bat_order")
@Getter
@Setter
public class PaycoreactAccountBatOrder extends AbstractEntity {

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
     * 支付批量订单号
     */
	@NotEmpty
	@Size(max = 32)
    private String batchBizOrderNo;

    /**
     * 接入商ID
     */
	@Size(max = 32)
    private String partnerId;

    /**
     * 操作类型
     */
	@Size(max = 32)
    private String orderType;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 备注
     */
	@Size(max = 512)
    private String comments;

    /**
     * 外部备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * 交易类型
     */
	@Size(max = 32)
    private String tradeType;

    /**
     * 扩展字段json
     */
	@Size(max = 1024)
    private String extContextJson;

}
