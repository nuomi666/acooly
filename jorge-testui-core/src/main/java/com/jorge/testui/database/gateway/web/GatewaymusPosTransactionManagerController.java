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
import com.jorge.testui.database.gateway.entity.GatewaymusPosTransaction;
import com.jorge.testui.database.gateway.service.GatewaymusPosTransactionService;

import com.google.common.collect.Maps;

/**
 * mus_pos_transaction 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:04:30
 */
@Controller
@RequestMapping(value = "/manage/jorge/gatewaymusPosTransaction")
public class GatewaymusPosTransactionManagerController extends AbstractJQueryEntityController<GatewaymusPosTransaction, GatewaymusPosTransactionService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private GatewaymusPosTransactionService gatewaymusPosTransactionService;

	

}
