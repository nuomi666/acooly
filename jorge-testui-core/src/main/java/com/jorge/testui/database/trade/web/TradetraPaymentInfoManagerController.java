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
import com.jorge.testui.database.trade.entity.TradetraPaymentInfo;
import com.jorge.testui.database.trade.service.TradetraPaymentInfoService;

import com.google.common.collect.Maps;

/**
 * 通用交易支付信息 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 10:58:33
 */
@Controller
@RequestMapping(value = "/manage/jorge/tradetraPaymentInfo")
public class TradetraPaymentInfoManagerController extends AbstractJQueryEntityController<TradetraPaymentInfo, TradetraPaymentInfoService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private TradetraPaymentInfoService tradetraPaymentInfoService;

	

}
