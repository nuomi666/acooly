/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.member.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.member.entity.MembermemberPersonal;
import com.jorge.testui.database.member.service.MembermemberPersonalService;

import com.google.common.collect.Maps;

/**
 * 个人用户实名认证 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:03:17
 */
@Controller
@RequestMapping(value = "/manage/jorge/membermemberPersonal")
public class MembermemberPersonalManagerController extends AbstractJQueryEntityController<MembermemberPersonal, MembermemberPersonalService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private MembermemberPersonalService membermemberPersonalService;

	

}
