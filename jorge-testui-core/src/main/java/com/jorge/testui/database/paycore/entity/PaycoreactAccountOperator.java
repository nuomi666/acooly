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
 * 运营商表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:01:54
 */
@Entity
@Table(name = "act_account_operator")
@Getter
@Setter
public class PaycoreactAccountOperator extends AbstractEntity {

    /**
     * 运营商汇总余额
     */
    private Long balance;

    /**
     * 状态
     */
	@Size(max = 32)
    private String status;

    /**
     * 备注
     */
	@Size(max = 512)
    private String memo;

}
