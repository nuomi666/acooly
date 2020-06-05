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
import com.jorge.testui.database.gateway.entity.GatewaymusWithdrawTransaction;
import com.jorge.testui.database.gateway.service.GatewaymusWithdrawTransactionService;

import com.google.common.collect.Maps;

/**
 * mus_withdraw_transaction 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:04:31
 */
@Controller
@RequestMapping(value = "/manage/jorge/gatewaymusWithdrawTransaction")
public class GatewaymusWithdrawTransactionManagerController extends AbstractJQueryEntityController<GatewaymusWithdrawTransaction, GatewaymusWithdrawTransactionService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private GatewaymusWithdrawTransactionService gatewaymusWithdrawTransactionService;

	

}
