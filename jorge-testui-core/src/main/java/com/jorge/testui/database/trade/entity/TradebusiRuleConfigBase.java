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
import java.util.Date;

/**
 * 业务管控基础规则配置 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:31
 */
@Entity
@Table(name = "busi_rule_config_base")
@Getter
@Setter
public class TradebusiRuleConfigBase extends AbstractEntity {

    /**
     * 交易类型
     */
	@Size(max = 32)
    private String tradeType;

    /**
     * 单笔最小金额
     */
    private Long singleMinAmount;

    /**
     * 单笔最大金额
     */
    private Long singleMaxAmount;

    /**
     * 每日最大笔数
     */
    private Integer dailyMaxCount;

    /**
     * 每日最大总额
     */
    private Long dailyMaxAmount;

    /**
     * 每月最大笔数
     */
    private Integer monthlyMaxCount;

    /**
     * 每月最大总额
     */
    private Long monthlyMaxAmount;

}
