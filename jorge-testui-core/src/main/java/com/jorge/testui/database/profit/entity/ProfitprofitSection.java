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
 * profit_section Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:05:03
 */
@Entity
@Table(name = "profit_section")
@Getter
@Setter
public class ProfitprofitSection extends AbstractEntity {

    /**
     * eventId
     */
	@NotEmpty
	@Size(max = 32)
    private String eventId;

    /**
     * 段落名称
     */
	@Size(max = 128)
    private String sectionName;

    /**
     * 模板原始规则，方便解析
     */
	@NotEmpty
	@Size(max = 100000)
    private String templateRule;

    /**
     * 表达式规则，交易过程中用；与template_rule同步更新
     */
	@NotEmpty
	@Size(max = 100000)
    private String exprRule;

    /**
     * priority
     */
    private Integer priority;

    /**
     * 段落说明，包含条件说明等等
     */
	@Size(max = 256)
    private String memo;

}
