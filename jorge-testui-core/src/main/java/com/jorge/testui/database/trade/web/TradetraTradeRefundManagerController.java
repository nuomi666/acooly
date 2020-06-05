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
import com.jorge.testui.database.trade.entity.TradetraTradeRefund;
import com.jorge.testui.database.trade.service.TradetraTradeRefundService;

import com.google.common.collect.Maps;

/**
 * 交易退款 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 10:58:35
 */
@Controller
@RequestMapping(value = "/manage/jorge/tradetraTradeRefund")
public class TradetraTradeRefundManagerController extends AbstractJQueryEntityController<TradetraTradeRefund, TradetraTradeRefundService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private TradetraTradeRefundService tradetraTradeRefundService;

	

}
