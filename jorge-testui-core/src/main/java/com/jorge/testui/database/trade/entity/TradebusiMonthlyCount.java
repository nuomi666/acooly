/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.trade.entity;


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
 * 月统计数据 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:30
 */
@Entity
@Table(name = "busi_monthly_count")
@Getter
@Setter
public class TradebusiMonthlyCount extends AbstractEntity {

    /**
     * 用户号
     */
	@NotEmpty
	@Size(max = 20)
    private String userNo;

    /**
     * 交易类型
     */
	@Size(max = 32)
    private String tradeType;

    /**
     * 当月总交易笔数
     */
    private Long monthlyTotalNum;

    /**
     * 当月交易总额
     */
    private Long monthlyMoneyCount;

    /**
     * 统计月份
     */
	@Size(max = 20)
    private String month;

}
