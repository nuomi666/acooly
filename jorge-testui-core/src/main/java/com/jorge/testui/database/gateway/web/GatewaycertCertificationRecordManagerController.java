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
import com.jorge.testui.database.gateway.entity.GatewaycertCertificationRecord;
import com.jorge.testui.database.gateway.service.GatewaycertCertificationRecordService;

import com.google.common.collect.Maps;

/**
 * 实名认证记录表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-27 11:04:26
 */
@Controller
@RequestMapping(value = "/manage/jorge/gatewaycertCertificationRecord")
public class GatewaycertCertificationRecordManagerController extends AbstractJQueryEntityController<GatewaycertCertificationRecord, GatewaycertCertificationRecordService> {
	
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
	private GatewaycertCertificationRecordService gatewaycertCertificationRecordService;

	
	@Override
	protected void referenceData(HttpServletRequest request, Map<String, Object> model) {
		model.put("allStatuss", allStatuss);
	}

}
