/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.gateway.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.gateway.entity.GatewaymusChannelBankCode;
import com.jorge.testui.database.gateway.service.GatewaymusChannelBankCodeService;

import com.google.common.collect.Maps;

/**
 * 渠道银行编码对应表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:04:28
 */
@Controller
@RequestMapping(value = "/manage/jorge/gatewaymusChannelBankCode")
public class GatewaymusChannelBankCodeManagerController extends AbstractJQueryEntityController<GatewaymusChannelBankCode, GatewaymusChannelBankCodeService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private GatewaymusChannelBankCodeService gatewaymusChannelBankCodeService;

	

}
