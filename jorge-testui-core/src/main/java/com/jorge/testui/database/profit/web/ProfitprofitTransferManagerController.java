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
import com.jorge.testui.database.profit.entity.ProfitprofitTransfer;
import com.jorge.testui.database.profit.service.ProfitprofitTransferService;

import com.google.common.collect.Maps;

/**
 * profit_transfer 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:05:04
 */
@Controller
@RequestMapping(value = "/manage/jorge/profitprofitTransfer")
public class ProfitprofitTransferManagerController extends AbstractJQueryEntityController<ProfitprofitTransfer, ProfitprofitTransferService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ProfitprofitTransferService profitprofitTransferService;

	

}
