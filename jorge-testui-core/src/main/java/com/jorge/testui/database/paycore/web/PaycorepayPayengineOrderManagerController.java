/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.paycore.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineOrder;
import com.jorge.testui.database.paycore.service.PaycorepayPayengineOrderService;

import com.google.common.collect.Maps;

/**
 * 支付引擎订单表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:01:56
 */
@Controller
@RequestMapping(value = "/manage/jorge/paycorepayPayengineOrder")
public class PaycorepayPayengineOrderManagerController extends AbstractJQueryEntityController<PaycorepayPayengineOrder, PaycorepayPayengineOrderService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private PaycorepayPayengineOrderService paycorepayPayengineOrderService;

	

}
