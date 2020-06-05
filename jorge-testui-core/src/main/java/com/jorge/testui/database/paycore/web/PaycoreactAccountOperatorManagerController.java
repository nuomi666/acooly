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
import com.jorge.testui.database.paycore.entity.PaycoreactAccountOperator;
import com.jorge.testui.database.paycore.service.PaycoreactAccountOperatorService;

import com.google.common.collect.Maps;

/**
 * 运营商表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:01:54
 */
@Controller
@RequestMapping(value = "/manage/jorge/paycoreactAccountOperator")
public class PaycoreactAccountOperatorManagerController extends AbstractJQueryEntityController<PaycoreactAccountOperator, PaycoreactAccountOperatorService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private PaycoreactAccountOperatorService paycoreactAccountOperatorService;

	

}
