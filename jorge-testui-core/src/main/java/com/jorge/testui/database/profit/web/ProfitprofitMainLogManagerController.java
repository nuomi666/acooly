/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.profit.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.profit.entity.ProfitprofitMainLog;
import com.jorge.testui.database.profit.service.ProfitprofitMainLogService;

import com.google.common.collect.Maps;

/**
 * profit_main_log 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:05:03
 */
@Controller
@RequestMapping(value = "/manage/jorge/profitprofitMainLog")
public class ProfitprofitMainLogManagerController extends AbstractJQueryEntityController<ProfitprofitMainLog, ProfitprofitMainLogService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ProfitprofitMainLogService profitprofitMainLogService;

	

}
