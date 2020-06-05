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
import com.jorge.testui.database.member.entity.MembermemberBankCard;
import com.jorge.testui.database.member.service.MembermemberBankCardService;

import com.google.common.collect.Maps;

/**
 * 用户绑卡列表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:03:15
 */
@Controller
@RequestMapping(value = "/manage/jorge/membermemberBankCard")
public class MembermemberBankCardManagerController extends AbstractJQueryEntityController<MembermemberBankCard, MembermemberBankCardService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private MembermemberBankCardService membermemberBankCardService;

	

}
