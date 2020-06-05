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
 * mus_channel_route Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:04:28
 */
@Entity
@Table(name = "mus_channel_route")
@Getter
@Setter
public class GatewaymusChannelRoute extends AbstractEntity {

    /**
     * enabled
     */
	@Size(max = 255)
    private String enabled;

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
     * trade_type
     */
	@Size(max = 255)
    private String tradeType;

    /**
     * parent_id
     */
	@Size(max = 255)
    private String parentId;

    /**
     * route_type
     */
	@Size(max = 255)
    private String routeType;

    /**
     * user_no
     */
	@Size(max = 255)
    private String userNo;

    /**
     * busi_data
     */
	@Size(max = 255)
    private String busiData;

    /**
     * bank_key_id
     */
	@Size(max = 255)
    private String bankKeyId;

}
