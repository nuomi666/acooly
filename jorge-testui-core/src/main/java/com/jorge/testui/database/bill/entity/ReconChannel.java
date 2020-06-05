/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-05
*/
package com.jorge.testui.database.bill.entity;


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
 * 渠道配置表 Entity
 *
 * @author mufanglin
 * Date: 2019-12-05 09:52:01
 */
@Entity
@Table(name = "recon_channel")
@Getter
@Setter
public class ReconChannel extends AbstractEntity {

    /**
     * 渠道类型
     */
	@NotEmpty
	@Size(max = 64)
    private String channelType;

    /**
     * 是否启用
     */
	@NotEmpty
	@Size(max = 64)
    private String activeStatus;

    /**
     * 备注
     */
	@Size(max = 255)
    private String comments;

}
