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
 * mus_bank_card_bin Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:26
 */
@Entity
@Table(name = "mus_bank_card_bin")
@Getter
@Setter
public class GatewaymusBankCardBin extends AbstractEntity {

    /**
     * bank_card_attr
     */
	@Size(max = 255)
    private String bankCardAttr;

    /**
     * bank_code
     */
	@Size(max = 255)
    private String bankCode;

    /**
     * bank_name
     */
	@Size(max = 255)
    private String bankName;

    /**
     * bank_no
     */
	@Size(max = 255)
    private String bankNo;

    /**
     * card_flag
     */
	@Size(max = 255)
    private String cardFlag;

    /**
     * card_flag_len
     */
    private Integer cardFlagLen;

    /**
     * card_length
     */
    private Integer cardLength;

    /**
     * card_name
     */
	@Size(max = 255)
    private String cardName;

    /**
     * card_num
     */
	@Size(max = 255)
    private String cardNum;

    /**
     * card_type
     */
	@Size(max = 255)
    private String cardType;

    /**
     * comments
     */
	@Size(max = 255)
    private String comments;

}
