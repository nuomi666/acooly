/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-05
*/
package com.jorge.testui.database.bill.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.bill.entity.ReconPeriod;
import com.jorge.testui.database.bill.service.ReconPeriodService;

import com.google.common.collect.Maps;

/**
 * 每日对账结果 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-12-05 09:52:01
 */
@Controller
@RequestMapping(value = "/manage/jorge/reconPeriod")
public class ReconPeriodManagerController extends AbstractJQueryEntityController<ReconPeriod, ReconPeriodService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ReconPeriodService reconPeriodService;

	

}
