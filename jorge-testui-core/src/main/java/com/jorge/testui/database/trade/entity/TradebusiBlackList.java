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
 * 业务管控黑名单 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 10:58:30
 */
@Entity
@Table(name = "busi_black_list")
@Getter
@Setter
public class TradebusiBlackList extends AbstractEntity {

    /**
     * 用户号
     */
	@NotEmpty
	@Size(max = 20)
    private String userNo;

    /**
     * 交易类型
     */
	@NotEmpty
	@Size(max = 64)
    private String tradeType;

    /**
     * 名单状态
     */
	@NotEmpty
	@Size(max = 32)
    private String status;

    /**
     * 备注
     */
	@Size(max = 255)
    private String memo;

}
