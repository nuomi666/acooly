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
 * 账户操作记录表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:53
 */
@Entity
@Table(name = "act_account_action")
@Getter
@Setter
public class PaycoreactAccountAction extends AbstractEntity {

    /**
     * 外部商户订单号
     */
	@Size(max = 64)
    private String merchOrderNo;

    /**
     * 支付订单号
     */
	@NotEmpty
	@Size(max = 32)
    private String bizOrderNo;

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
     * 操作类型
     */
	@Size(max = 32)
    private String actionType;

    /**
     * 原始状态
     */
	@Size(max = 32)
    private String oldStatus;

    /**
     * 变动后状态
     */
	@Size(max = 32)
    private String newStatus;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

    /**
     * gid
     */
	@Size(max = 255)
    private String gid;

}
