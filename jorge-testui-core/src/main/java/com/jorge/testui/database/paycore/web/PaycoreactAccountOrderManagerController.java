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
import com.jorge.testui.database.paycore.entity.PaycoreactAccountOrder;
import com.jorge.testui.database.paycore.service.PaycoreactAccountOrderService;

import com.google.common.collect.Maps;

/**
 * 账务系统订单表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:01:55
 */
@Controller
@RequestMapping(value = "/manage/jorge/paycoreactAccountOrder")
public class PaycoreactAccountOrderManagerController extends AbstractJQueryEntityController<PaycoreactAccountOrder, PaycoreactAccountOrderService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private PaycoreactAccountOrderService paycoreactAccountOrderService;

	

}
