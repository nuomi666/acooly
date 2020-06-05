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
import com.jorge.testui.database.member.entity.MembermemberOpenApply;
import com.jorge.testui.database.member.service.MembermemberOpenApplyService;

import com.google.common.collect.Maps;

/**
 * 会员开通支付能力申请订单 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:03:16
 */
@Controller
@RequestMapping(value = "/manage/jorge/membermemberOpenApply")
public class MembermemberOpenApplyManagerController extends AbstractJQueryEntityController<MembermemberOpenApply, MembermemberOpenApplyService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private MembermemberOpenApplyService membermemberOpenApplyService;

	

}
