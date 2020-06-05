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
//import com.alibaba.fastjson.JSONObject;
//import com.jorge.testui.annotation.CaseApiService;
//import com.jorge.testui.database.member.dao.MembermemberDao;
//import com.jorge.testui.database.member.entity.Membermember;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//
///**
// * @author zhike
// * @date 2019-07-19 15:46
// */
//@Slf4j
//@CaseApiService(caseNo = "testCaseTest", desc = "测试用例", owner = "志客")
//public class TestCaseTestService{
//
//        @Resource
//        TestInsertUtil testInsertUtil;
//
//        @Resource
//        MembermemberDao membermemberDao;
//
//
//    public static void main(String[] args) {
////            String payerUserNo="20010811011566A80001";
////            String buyerUserNo="20010811011566A80001";
////            String payerUserName="test";
////            2001081652323B740026，19092311111717110027，19092311124346110039
//
////            String sellerUserNo="19092311111717110027";
////            String payeeUserNo="19092311111717110027";
//////            String gatewayUrl="http://172.17.100.40:8080/gateway.do";
////            String gatewayUrl="http://127.0.0.1:8080/gateway.do";
////            String partnerId= "19092311080520110003";
////            String securityKey="06f7aab08aa2431e6dae6a156fc9e0b4";
////            String accessKey="19092311080520110003";
////            线上数据，不要乱用
////            付款方buyerUserNo,payerUserNo="19102516345600010011";
////            收款人sellerUserNo,payeeUserNo="19102515073200010005";
////            String payerUserNo="20010811011566A80001";
////            String buyerUserNo="19102516345600010011";
////            String payerUserName="test";
//            String sellerUserNo="19102516345600010011";
//            String payeeUserNo="19102516345600010011";
//            String gatewayUrl="https://openapi-pay.cartechfin.com/gateway.do";
//            String partnerId= "19102515073200010005";
//            String accessKey="19102515073200010005";
//            String securityKey="83b95b25056b3dcc49027403a3a2bc1e";
////            String partnerId= "19123109144090100420";
////            String accessKey="19123109144090100420";
////            String securityKey="87ffa121535e605c0a9ba7bc6170b58e";
//            JSONObject object = TestCreatUtil.createTrade(sellerUserNo,null,
//                    null, null,
//                    payeeUserNo, gatewayUrl,
//                    partnerId, securityKey,
//                    accessKey);
//            System.out.println(object);
//            System.out.println(object.getString("merchOrderNo"));
//            String merchOrderNo = object.getString("merchOrderNo");
////            String merchOrderNo = "20011717595635450002";
////            20012014500303400002,20012017034903400002
//
//            JSONObject object1 = TestCreatUtil.oneCodePay(merchOrderNo,gatewayUrl,
//                    partnerId,securityKey,accessKey,payeeUserNo);
//
////            JSONObject object1 = TestCreatUtil.rechargeRedirect(merchOrderNo,gatewayUrl,
////                partnerId,securityKey,accessKey,payeeUserNo);
////
////            JSONObject object1 = TestCreatUtil.tradePayRedirect(merchOrderNo,gatewayUrl,
////                partnerId,securityKey,accessKey,payeeUserNo);
////
////            JSONObject object1 = TestCreatUtil.transferAccountRedirect(merchOrderNo,gatewayUrl,
////                partnerId,securityKey,accessKey,payeeUserNo);
////
////            JSONObject object1 = TestCreatUtil.withdrawRedirect(merchOrderNo,gatewayUrl,
////                partnerId,securityKey,accessKey,payeeUserNo);
//            System.out.println(object1);
//        }
//
//}
