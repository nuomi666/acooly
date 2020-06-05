//package com.jorge.testui.service;
//
//import com.acooly.core.utils.Ids;
//import com.jorge.testui.CaseConstants;
//import com.jorge.testui.annotation.CaseApiService;
//import com.jorge.testui.service.base.BaseCaseService;
//import com.jorge.testui.service.message.TestCaseOneApiResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.log4j.MDC;
//
///**
// * @author mufanglin
// * @email 280932756@qq.com
// * @date 2019-07-23 17:31
// */
//@Slf4j
//@CaseApiService(caseNo = "testCaseTwo",desc = "测试用例",owner = "牟方林")
//public class TestCaseTwoService extends BaseCaseService<TestCaseOneApiRequest, TestCaseOneApiResponse> {
//    @Override
//    protected void doService(TestCaseOneApiRequest request, TestCaseOneApiResponse response) {
//        log.info("测试2请求报文");
//        MDC.put(CaseConstants.GID, Ids.gid());
//        if (request.getUserNo().equals("123")){
//            response.setSuccess(true);
//        }
//        else {
//            response.setSuccess(false);
//        }
//        response.setCaseNo(request.getCaseNo());
//        response.setContext("test2");
//        response.setGatewayUrl(request.getGatewayUrl());
//    }
//}
