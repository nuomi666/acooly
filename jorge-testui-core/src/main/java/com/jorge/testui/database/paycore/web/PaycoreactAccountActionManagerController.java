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
import com.jorge.testui.database.paycore.entity.PaycoreactAccountAction;
import com.jorge.testui.database.paycore.service.PaycoreactAccountActionService;

import com.google.common.collect.Maps;

/**
 * 账户操作记录表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:01:53
 */
@Controller
@RequestMapping(value = "/manage/jorge/paycoreactAccountAction")
public class PaycoreactAccountActionManagerController extends AbstractJQueryEntityController<PaycoreactAccountAction, PaycoreactAccountActionService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private PaycoreactAccountActionService paycoreactAccountActionService;

	

}
