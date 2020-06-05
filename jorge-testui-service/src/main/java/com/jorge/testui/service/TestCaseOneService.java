//
///**
// * jorge-testui-parent
// * <p>
// * Copyright 2019 Acooly.cn, Inc. All rights reserved.
// *
// * @author zhike
// * @date 2019-07-19 15:46
// */
//package com.jorge.testui.service;
//
//
//import com.acooly.core.utils.Ids;
//import com.alibaba.fastjson.JSONObject;
//import com.jorge.testui.CaseConstants;
//import com.jorge.testui.annotation.CaseApiService;
//import com.jorge.testui.database.trade.dao.TradefunFundDao;
//import com.jorge.testui.service.base.BaseCaseService;
//import com.jorge.testui.service.message.TestCaseOneApiResponse;
//import com.jorge.testui.utils.AssertsUtil;
//import com.jorge.testui.utils.HttpUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.log4j.MDC;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author zhike
// * @date 2019-07-19 15:46
// */
//@Slf4j
//@CaseApiService(caseNo = "testCaseOne", desc = "测试用例", owner = "志客")
//public class TestCaseOneService extends BaseCaseService<TestCaseOneApiRequest, TestCaseOneApiResponse> {
//
//    @Resource
//    TradefunFundDao tradefunFundDao;
//
//    @Override
//    protected void doService(TestCaseOneApiRequest request, TestCaseOneApiResponse response) {
//        MDC.put(CaseConstants.GID, Ids.gid());
//        log.info("测试1请求报文：{}", request);
//        Map<String, Object> map = new HashMap<String, Object>();
//        JSONObject responseEntity = new JSONObject();
//        String securityKey = request.getSecurityKey();
//        String accessKey = request.getAccessKey();
//        String partnerId = request.getPartnerId();
//        //组装请求参数
//        map.put("userNo",request.getUserNo());
//        request.getInterfaces().getInterfaceName();
//        tradefunFundDao.findUniqu("EQ_merchOrderNo","o19092014185163800017");
//
//        //发送请求
//
//        //得到数据结果
//        responseEntity = HttpUtil.httpRequest(request, map);
//        response.setContext(JSONObject.toJSONString(map));
//        response.setApiResponse(JSONObject.toJSONString(responseEntity));
//
//        //数据校验
//        AssertsUtil.assertThan("1",1);
//
//        response.setCaseNo(request.getCaseNo());
//        response.setSuccess(true);
//        response.setGatewayUrl(request.getGatewayUrl());
//    }
//
//}
