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
import com.jorge.testui.database.trade.entity.TradebusiRuleConfig;
import com.jorge.testui.database.trade.service.TradebusiRuleConfigService;

import com.google.common.collect.Maps;

/**
 * 业务管控规则配置 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 10:58:31
 */
@Controller
@RequestMapping(value = "/manage/jorge/tradebusiRuleConfig")
public class TradebusiRuleConfigManagerController extends AbstractJQueryEntityController<TradebusiRuleConfig, TradebusiRuleConfigService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private TradebusiRuleConfigService tradebusiRuleConfigService;

	

}
