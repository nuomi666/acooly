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
 * profit_template Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:05:04
 */
@Entity
@Table(name = "profit_template")
@Getter
@Setter
public class ProfitprofitTemplate extends AbstractEntity {

    /**
     * 模板编码,原型模板时代表key值
     */
	@NotEmpty
	@Size(max = 128)
    private String templateCode;

    /**
     * 模板名称,原型模板时代表key对应的名字
     */
	@NotEmpty
	@Size(max = 256)
    private String templateName;

    /**
     * 范畴,如：条件,行为,模式,产品
     */
	@NotEmpty
	@Size(max = 32)
    private String category;

    /**
     * 模板类型：周期,计量,渠道,公私,用户级别,卡类型,金额;报警,收费,拒绝;模式;产品
     */
	@NotEmpty
	@Size(max = 32)
    private String type;

    /**
     * 模板解析方式,如：枚举,区间,产品
     */
	@NotEmpty
	@Size(max = 32)
    private String classify;

    /**
     * 模板类容
     */
	@NotEmpty
	@Size(max = 100000)
    private String template;

    /**
     * 备注信息
     */
	@NotEmpty
	@Size(max = 128)
    private String memo;

}
