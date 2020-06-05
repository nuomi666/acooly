/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-11
*/
package com.jorge.testui.database.openapi.entity;


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
 * api_notify_message Entity
 *
 * @author mufanglin
 * Date: 2019-12-11 10:58:11
 */
@Entity
@Table(name = "api_notify_message")
@Getter
@Setter
public class ApiNotifyMessage extends AbstractEntity {

    /**
     * gid
     */
	@Size(max = 40)
    private String gid;

    /**
     * partner_id
     */
	@Size(max = 40)
    private String partnerId;

    /**
     * request_no
     */
	@Size(max = 40)
    private String requestNo;

    /**
     * merch_order_no
     */
	@Size(max = 40)
    private String merchOrderNo;

    /**
     * message_type
     */
	@NotEmpty
	@Size(max = 16)
    private String messageType;

    /**
     * service
     */
	@Size(max = 32)
    private String service;

    /**
     * version
     */
	@Size(max = 8)
    private String version;

    /**
     * url
     */
	@NotEmpty
	@Size(max = 255)
    private String url;

    /**
     * content
     */
	@NotEmpty
	@Size(max = 1024)
    private String content;

    /**
     * resp_info
     */
	@Size(max = 128)
    private String respInfo;

    /**
     * send_count
     */
	@NotNull
    private Integer sendCount;

    /**
     * next_send_time
     */
    private Date nextSendTime;

    /**
     * status
     */
	@NotEmpty
	@Size(max = 16)
    private String status;

    /**
     * execute_status
     */
	@NotEmpty
	@Size(max = 16)
    private String executeStatus;

    /**
     * protocol
     */
	@Size(max = 32)
    private String protocol;

    /**
     * sign_type
     */
	@Size(max = 40)
    private String signType;

    /**
     * sign
     */
	@Size(max = 64)
    private String sign;

}
