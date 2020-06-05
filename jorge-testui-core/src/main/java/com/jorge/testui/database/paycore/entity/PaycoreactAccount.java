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
 * 用户账户 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:53
 */
@Entity
@Table(name = "act_account")
@Getter
@Setter
public class PaycoreactAccount extends AbstractEntity {

    /**
     * 接入商ID
     */
	@Size(max = 32)
    private String partnerId;

    /**
     * 用户编码
     */
	@Size(max = 32)
    private String userNo;

    /**
     * 用户名
     */
	@Size(max = 32)
    private String userName;

    /**
     * 账户渠道
     */
	@Size(max = 32)
    private String accountChannel;

    /**
     * 账户类型
     */
	@Size(max = 32)
    private String accountType;

    /**
     * 账户号
     */
	@Size(max = 64)
    private String accountNo;

    /**
     * 银行资金账户
     */
	@Size(max = 64)
    private String bankAccountNo;

    /**
     * 账户余额
     */
    private Long balance;

    /**
     * 冻结金额
     */
    private Long freeze;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 内部备注
     */
	@Size(max = 128)
    private String memo;

    /**
     * 外部备注
     */
	@Size(max = 128)
    private String comments;

}
