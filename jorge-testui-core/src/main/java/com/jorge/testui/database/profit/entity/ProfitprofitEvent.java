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
 * profit_event Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:05:03
 */
@Entity
@Table(name = "profit_event")
@Getter
@Setter
public class ProfitprofitEvent extends AbstractEntity {

    /**
     * 用户ID
     */
	@Size(max = 32)
    private String partnerId;

    /**
     * 事件类型
     */
	@NotEmpty
	@Size(max = 20)
    private String eventType;

    /**
     * 参与角色，分割符为|
     */
	@Size(max = 512)
    private String eventRoles;

    /**
     * 默认收款帐号
     */
	@Size(max = 32)
    private String defaultAccountNo;

    /**
     * 默认中间参与人
     */
	@Size(max = 32)
    private String middleAccountNo;

    /**
     * 折扣
     */
	@Size(max = 20)
    private String discount;

    /**
     * 状态:
     */
	@NotEmpty
	@Size(max = 20)
    private String state;

    /**
     * 生效开始时间
     */
    private Date effDate;

    /**
     * 生效结束时间
     */
    private Date expDate;

    /**
     * 备注
     */
	@Size(max = 255)
    private String memo;

}
