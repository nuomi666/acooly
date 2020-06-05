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
import com.jorge.testui.database.trade.entity.TradetraTradePos;
import com.jorge.testui.database.trade.service.TradetraTradePosService;

import com.google.common.collect.Maps;

/**
 * pos交易订单数据 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 10:58:34
 */
@Controller
@RequestMapping(value = "/manage/jorge/tradetraTradePos")
public class TradetraTradePosManagerController extends AbstractJQueryEntityController<TradetraTradePos, TradetraTradePosService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private TradetraTradePosService tradetraTradePosService;

	

}
