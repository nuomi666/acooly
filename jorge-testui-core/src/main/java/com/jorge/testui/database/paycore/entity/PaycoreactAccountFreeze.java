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
 * 冻结账户表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:54
 */
@Entity
@Table(name = "act_account_freeze")
@Getter
@Setter
public class PaycoreactAccountFreeze extends AbstractEntity {

    /**
     * 账户号
     */
	@Size(max = 64)
    private String accountNo;

    /**
     * 冻结类型
     */
	@Size(max = 32)
    private String freezeType;

    /**
     * 冻结金额余额
     */
    private Long freezeBalance;

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
