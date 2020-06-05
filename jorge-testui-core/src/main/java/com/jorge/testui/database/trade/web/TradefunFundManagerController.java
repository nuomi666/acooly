/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.trade.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.trade.entity.TradefunFund;
import com.jorge.testui.database.trade.service.TradefunFundService;

import com.google.common.collect.Maps;

/**
 * 充值提现订单 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 10:58:32
 */
@Controller
@RequestMapping(value = "/manage/jorge/tradefunFund")
public class TradefunFundManagerController extends AbstractJQueryEntityController<TradefunFund, TradefunFundService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private TradefunFundService tradefunFundService;

	

}
