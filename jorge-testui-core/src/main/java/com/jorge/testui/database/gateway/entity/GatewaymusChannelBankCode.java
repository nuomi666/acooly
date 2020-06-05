/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.gateway.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 渠道银行编码对应表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:28
 */
@Entity
@Table(name = "mus_channel_bank_code")
@Getter
@Setter
public class GatewaymusChannelBankCode extends AbstractEntity {

    /**
     * 渠道API编码
     */
	@Size(max = 60)
    private String instChannelApi;

    /**
     * 银行编码
     */
	@Size(max = 128)
    private String bankCode;

    /**
     * 银行名称
     */
	@Size(max = 128)
    private String bankName;

    /**
     * 基准银行编码
     */
	@Size(max = 128)
    private String baseBankCode;

    /**
     * 状态
     */
	@Size(max = 12)
    private String status;

}
