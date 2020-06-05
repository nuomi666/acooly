//package com.jorge.testui.service.bill;
//
//import com.acooly.core.common.facade.ResultBase;
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.cartechfin.cheyunpay.bill.api.NotifyBillFacade;
//import com.jorge.testui.annotation.CaseApiService;
//import com.jorge.testui.message.CaseBaseResponse;
//import com.jorge.testui.service.base.BaseCaseService;
//import com.jorge.testui.service.message.bill.NotifyBillFacadeSaveTradeInfoListTestSuccessApiRequest;
//import lombok.extern.slf4j.Slf4j;
//
//
///**
// * @author zhoudongling
// * @email
// * @date 2020-02-18 10:07
// */
//@Slf4j
//@CaseApiService(caseNo = "notifyBillFacadeSaveTradeInfoListTestSuccessService", desc = "查询提现记录成功", owner = "mfl")
//public class NotifyBillFacadeSaveTradeInfoListTestSuccessService extends BaseCaseService<NotifyBillFacadeSaveTradeInfoListTestSuccessApiRequest, CaseBaseResponse> {
//
//    @Reference(version = "1.0")
//    NotifyBillFacade notifyBillFacade;
//
//    @Override
//    protected void doService(NotifyBillFacadeSaveTradeInfoListTestSuccessApiRequest request, CaseBaseResponse response) {
//        //清除数据
//
//        //准备数据
//
//        //测试过程
//
//        //调用接口
//        request.getTradeInfoListOrder().add(request.getTradeInfoOrder());
//        request.getSaveTradeInfoListOrder().setTradeInfoListOrder(request.getTradeInfoListOrder());
//        ResultBase result = notifyBillFacade.saveTradeInfoList(request.getSaveTradeInfoListOrder());
//
//        //结果验证
//
//        //数据验证
//
//        //清除数据
//        response.setCaseNo(request.getCaseNo());
//        response.setSuccess(true);
//        response.setGatewayUrl(request.getGatewayUrl());
//        response.setApiResponse(request.toString());
//        response.setContext(request.getSaveTradeInfoListOrder().toString());
//
//    }
//}
