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
import com.jorge.testui.database.profit.entity.ProfitprofitTemplate;
import com.jorge.testui.database.profit.service.ProfitprofitTemplateService;

import com.google.common.collect.Maps;

/**
 * profit_template 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:05:04
 */
@Controller
@RequestMapping(value = "/manage/jorge/profitprofitTemplate")
public class ProfitprofitTemplateManagerController extends AbstractJQueryEntityController<ProfitprofitTemplate, ProfitprofitTemplateService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ProfitprofitTemplateService profitprofitTemplateService;

	

}
