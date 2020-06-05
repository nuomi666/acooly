/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-11
*/
package com.jorge.testui.database.openapi.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.openapi.entity.ApiOrderInfo;
import com.jorge.testui.database.openapi.service.ApiOrderInfoService;

import com.google.common.collect.Maps;

/**
 * 请求信息表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-12-11 10:58:11
 */
@Controller
@RequestMapping(value = "/manage/jorge/apiOrderInfo")
public class ApiOrderInfoManagerController extends AbstractJQueryEntityController<ApiOrderInfo, ApiOrderInfoService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ApiOrderInfoService apiOrderInfoService;

	

}
