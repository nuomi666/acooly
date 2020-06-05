/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.profit.entity;


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
 * profit_action_rule Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:05:02
 */
@Entity
@Table(name = "profit_action_rule")
@Getter
@Setter
public class ProfitprofitActionRule extends AbstractEntity {

    /**
     * 段落id
     */
	@NotEmpty
	@Size(max = 32)
    private String sectionId;

    /**
     * 计算类型
     */
	@NotEmpty
	@Size(max = 32)
    private String calType;

    /**
     * 计算费率
     */
	@NotEmpty
	@Size(max = 512)
    private String calRate;

    /**
     * 付款角色
     */
	@NotEmpty
	@Size(max = 32)
    private String payerRole;

    /**
     * 付款账号
     */
	@Size(max = 32)
    private String payerAccount;

    /**
     * 收款角色
     */
	@NotEmpty
	@Size(max = 32)
    private String payeeRole;

    /**
     * 收款账号
     */
	@Size(max = 32)
    private String payeeAccount;

    /**
     * 备注
     */
	@Size(max = 256)
    private String memo;

}
