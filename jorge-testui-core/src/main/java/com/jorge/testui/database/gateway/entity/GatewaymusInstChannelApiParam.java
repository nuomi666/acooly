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
 * mus_inst_channel_api_param Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:29
 */
@Entity
@Table(name = "mus_inst_channel_api_param")
@Getter
@Setter
public class GatewaymusInstChannelApiParam extends AbstractEntity {

    /**
     * extend_params
     */
	@Size(max = 255)
    private String extendParams;

    /**
     * gateway_url
     */
	@Size(max = 255)
    private String gatewayUrl;

    /**
     * inst_channel_api
     */
	@Size(max = 255)
    private String instChannelApi;

    /**
     * memo
     */
	@Size(max = 255)
    private String memo;

    /**
     * notify_url
     */
	@Size(max = 255)
    private String notifyUrl;

    /**
     * return_url
     */
	@Size(max = 255)
    private String returnUrl;

}
