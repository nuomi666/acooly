package com.jorge.testui.mock.gateway.fmbank.trade;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.database.mock.dao.MockDepositOrderDao;
import com.jorge.testui.database.mock.entity.MockDepositOrder;
import com.jorge.testui.database.mock.service.MockDepositOrderService;
import com.jorge.testui.enums.ConfirmStatusEnum;
import com.jorge.testui.enums.GatewayChannelApiEnum;
import com.jorge.testui.enums.MockNotifyStatusEnum;
import com.jorge.testui.enums.MockStatusEnum;
import com.jorge.testui.mock.gateway.MockUtils;
import com.jorge.testui.mock.web.common.base.MockRequestOrderBase;
import com.jorge.testui.mock.web.common.result.MockResponseResult;
import com.jorge.testui.service.base.AbstractMockGatewayService;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 1.需要修改配置(网关)：
 *      acooly.openapi.client.fbank.payolGatewayUrl=http://127.0.0.1:8999/mock/gateway
 *
 * 2.mock银行返回状态说明 (金额单位 为 分)
 *      交易金额 为 ：   失    败： 0 < amount <= 800
 *                      处 理 中： 800 < amount <= 19600
 *
 * 3.异步查询，当金额为 1619 时，异步处理失败(金额单位 为 分)
 *
 *
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2019/12/13 0029
 */

@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FMPayWeixinJsService, desc = "富民微信公众号服务(线下)", owner
        = "ck.wu")
public class FMFMPayWeixinJServices extends
        AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {
    
    @Resource
    MockRequestOrderBase mockRequestOrderBase;
    @Autowired
    MockDepositOrderDao mockDepositOrderDao;
    @Autowired
    MockDepositOrderService mockDepositOrderService;
   
    
    /**
     *
     * 富民微信公众号服务(线下)
     *
     * @param request
     * @param result
     */
    @Override
    public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
        try {
            MockDepositOrder mockDepositOrder = new MockDepositOrder();
            log.info("MOCK-请求-富民微信公众号服务(线下)-请求订单 ： {}", request);
    
            mockRequestOrderBase.initFMFMPayWeixinJSOrder(result.getRequestData(),mockDepositOrder);
            long amount = mockDepositOrder.getAmount();
            JSONObject requestData = new JSONObject();
            JSONObject data = new JSONObject();
            if(amount == 0){
                MockDepositOrder MockDepositOrderUpdate = new MockDepositOrder();
                MockDepositOrder mockDepositOrderResult = mockDepositOrderDao
                        .findEntityByBizOrderNoAndMockStatus(mockDepositOrder.getBizOrderNo());
                
                MockDepositOrderUpdate.setBizOrderNo(mockDepositOrderResult.getBizOrderNo());
                if( amount == 1619 ){
                    data.put("timestamp",new Date());
                    requestData.put("code", "00669");
                    requestData.put("data", data);
                    MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
                    MockDepositOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
                } else {
                    data.put("timestamp",new Date());
                    data.put("package","prepay_id=wx23165106846228b766707bd71327840400");
                    data.put("paySign","BkE3vtwggBd+7EIF4E3S7lWgMBPewMcCRtVaIhF5+so4Y2UcTV4Eimk1GeosZtOVzETJG+mJXdZlP+0Tg2JxNk5WmWW1v5WFhp15G6pwH7E9B2bHYcNjvFlFqn/lEqZ0yxGnkDE/fWfxjkmJ5i1RfDKr9uC/V82hTAdmWE78xHPwXkeCLj2O4rxkQxxp9aT6ZZ4Joi0Beczo7MJZtRNVln0QnPKzaWEzA1NOysNXR6vAuLIEHRqr86/3wS20hBVwhs5+tULojj9WuT3h0zgsex+yu66XG63et7XaB2uso51/YV+V83n5ZMNZ68HiXk6F95jVUTCzK/mj2n2ho27Qww==");
                    data.put("appId","wxa5236b4da0bd1596");
                    data.put("signType","RSA");
                    data.put("nonceStr","9ac7fe6458a84e3bbc06be9b79cf935b");
                    requestData.put("code", "10000");
                    requestData.put("payInfo", data);
                    requestData.put("paySt","2");
                    requestData.put("amount", String.valueOf(mockDepositOrderResult.getAmount()));
                    MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
                    MockDepositOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
                }
                MockDepositOrderUpdate.setMockNotifyCount(mockDepositOrderResult.getMockNotifyCount() + 1);
    
                mockDepositOrderService.updateMockDepositOrder(MockDepositOrderUpdate);
            } else {
                if( MockUtils.hundreds(amount) == 0 ){
                    data.put("timestamp",new Date());
                    requestData.put("code", "111111");
                    requestData.put("data", data);
                    mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
                    mockDepositOrder.setConfirmStatus(ConfirmStatusEnum.FAIL.code());
                }else if(MockUtils.hundreds(amount) == 1) {
                    log.info("成功没有实现，不会直接返回成功！");
                } else{
                    data.put("timestamp",new Date());
                    data.put("package","prepay_id=wx23165106846228b766707bd71327840400");
                    data.put("paySign","BkE3vtwggBd+7EIF4E3S7lWgMBPewMcCRtVaIhF5+so4Y2UcTV4Eimk1GeosZtOVzETJG+mJXdZlP+0Tg2JxNk5WmWW1v5WFhp15G6pwH7E9B2bHYcNjvFlFqn/lEqZ0yxGnkDE/fWfxjkmJ5i1RfDKr9uC/V82hTAdmWE78xHPwXkeCLj2O4rxkQxxp9aT6ZZ4Joi0Beczo7MJZtRNVln0QnPKzaWEzA1NOysNXR6vAuLIEHRqr86/3wS20hBVwhs5+tULojj9WuT3h0zgsex+yu66XG63et7XaB2uso51/YV+V83n5ZMNZ68HiXk6F95jVUTCzK/mj2n2ho27Qww==");
                    data.put("appId","wxa5236b4da0bd1596");
                    data.put("signType","RSA");
                    data.put("nonceStr","9ac7fe6458a84e3bbc06be9b79cf935b");
                    requestData.put("code", "10000");
                    requestData.put("payInfo", data);
                    mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
                    mockDepositOrder.setConfirmStatus(ConfirmStatusEnum.PROCESSING.code());
                }
                mockDepositOrderService.saveMockDepositOrder(mockDepositOrder);
            }
        
            result.setData(requestData);
            result.setPayInfo(data);
            log.info("MOCK-富民微信公众号服务(线下) - 应答 requestResult ： {}", result);
        } catch (Exception e) {
            log.error("MOCK-富民微信公众号服务(线下)应答-异常，错误信息:{}", e);
        }
    }
    
}
