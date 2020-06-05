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
import com.jorge.testui.database.bill.entity.ReconChannel;
import com.jorge.testui.database.bill.service.ReconChannelService;

import com.google.common.collect.Maps;

/**
 * 渠道配置表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-12-05 09:52:01
 */
@Controller
@RequestMapping(value = "/manage/jorge/reconChannel")
public class ReconChannelManagerController extends AbstractJQueryEntityController<ReconChannel, ReconChannelService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ReconChannelService reconChannelService;

	

}
