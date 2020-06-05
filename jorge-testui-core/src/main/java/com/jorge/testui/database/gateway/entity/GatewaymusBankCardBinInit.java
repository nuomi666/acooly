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
 * 卡BIN信息表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:27
 */
@Entity
@Table(name = "mus_bank_card_bin_init")
@Getter
@Setter
public class GatewaymusBankCardBinInit extends AbstractEntity {

    /**
     * 银行全称
     */
	@Size(max = 50)
    private String bankName;

    /**
     * 银行英文简称
     */
	@Size(max = 10)
    private String bankNo;

    /**
     * 发卡行机构代码
     */
	@Size(max = 16)
    private String bankCode;

    /**
     * 对公对私
     */
	@Size(max = 12)
    private String bankCardAttr;

    /**
     * 卡产品名称
     */
	@Size(max = 50)
    private String cardName;

    /**
     * 借贷类型
     */
	@Size(max = 20)
    private String cardType;

    /**
     * 卡号长度
     */
    private Integer cardLength;

    /**
     * 示范卡号
     */
	@Size(max = 50)
    private String cardNum;

    /**
     * 卡标记的长度
     */
    private Integer cardFlagLen;

    /**
     * 卡识别标记
     */
	@Size(max = 50)
    private String cardFlag;

    /**
     * 备注
     */
	@Size(max = 255)
    private String comments;

}
