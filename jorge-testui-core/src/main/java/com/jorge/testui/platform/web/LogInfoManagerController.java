/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-04
*/
package com.jorge.testui.platform.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.platform.entity.LogInfo;
import com.jorge.testui.platform.service.LogInfoService;

import com.google.common.collect.Maps;

/**
 * log_info 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-12-04 11:37:17
 */
@Controller
@RequestMapping(value = "/manage/jorge/logInfo")
public class LogInfoManagerController extends AbstractJQueryEntityController<LogInfo, LogInfoService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private LogInfoService logInfoService;

	

}
