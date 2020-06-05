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
import com.jorge.testui.database.paycore.entity.PaycoreactAccount;
import com.jorge.testui.database.paycore.service.PaycoreactAccountService;

import com.google.common.collect.Maps;

/**
 * 用户账户 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:01:53
 */
@Controller
@RequestMapping(value = "/manage/jorge/paycoreactAccount")
public class PaycoreactAccountManagerController extends AbstractJQueryEntityController<PaycoreactAccount, PaycoreactAccountService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private PaycoreactAccountService paycoreactAccountService;

	

}
