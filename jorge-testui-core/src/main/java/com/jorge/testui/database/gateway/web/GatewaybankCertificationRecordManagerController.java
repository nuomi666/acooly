/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.gateway.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.database.gateway.entity.GatewaybankCertificationRecord;
import com.jorge.testui.database.gateway.service.GatewaybankCertificationRecordService;

import com.google.common.collect.Maps;

/**
 * 银行卡四要素记录表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:04:25
 */
@Controller
@RequestMapping(value = "/manage/jorge/gatewaybankCertificationRecord")
public class GatewaybankCertificationRecordManagerController extends AbstractJQueryEntityController<GatewaybankCertificationRecord, GatewaybankCertificationRecordService> {
	
	private static Map<Integer, String> allStatuss = Maps.newLinkedHashMap();
	static {
		allStatuss.put(1, "验证通过");
		allStatuss.put(0, "未通过");
	}

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private GatewaybankCertificationRecordService gatewaybankCertificationRecordService;

	
	@Override
	protected void referenceData(HttpServletRequest request, Map<String, Object> model) {
		model.put("allStatuss", allStatuss);
	}

}
