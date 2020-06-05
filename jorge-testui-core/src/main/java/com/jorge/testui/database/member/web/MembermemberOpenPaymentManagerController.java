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
import com.jorge.testui.database.member.entity.MembermemberOpenPayment;
import com.jorge.testui.database.member.service.MembermemberOpenPaymentService;

import com.google.common.collect.Maps;

/**
 * 会员支付能力 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:03:16
 */
@Controller
@RequestMapping(value = "/manage/jorge/membermemberOpenPayment")
public class MembermemberOpenPaymentManagerController extends AbstractJQueryEntityController<MembermemberOpenPayment, MembermemberOpenPaymentService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private MembermemberOpenPaymentService membermemberOpenPaymentService;

	

}
