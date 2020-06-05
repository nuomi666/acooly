package com.jorge.testui.mock.gateway.chinaums;

import static com.jorge.testui.utils.ClassUtil.mapToObject;
import static com.jorge.testui.utils.DateUtils.getDateFormat;
import static com.jorge.testui.utils.DateUtils.getDateFormatss;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.acooly.core.utils.Servlets;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.database.mock.dao.MockDepositOrderDao;
import com.jorge.testui.database.mock.entity.MockDepositOrder;
import com.jorge.testui.database.mock.service.MockDepositOrderService;
import com.jorge.testui.enums.GatewayChannelApiEnum;
import com.jorge.testui.enums.MockNotifyStatusEnum;
import com.jorge.testui.enums.MockStatusEnum;
import com.jorge.testui.enums.TypeSourceEnum;
import com.jorge.testui.mock.gateway.MockUtils;
import com.jorge.testui.mock.web.common.base.MockRequestOrderBase;
import com.jorge.testui.mock.web.common.result.MockResponseResult;
import com.jorge.testui.service.base.AbstractMockGatewayService;

import lombok.extern.slf4j.Slf4j;

/**
 * 1.需要修改配置(网关)：
 *      acooly.openapi.client.chinaums.payolGatewayUrl=http://127.0.0.1:8999/mock/gateway
 *
 * 2.mock银行返回状态说明 (金额单位 为 分)
 *      交易金额 为 ：   失   败 ： 0 < amount <= 600
 *                      成   功 ： 600 < amount <= 16600
 *                      处 理 中： 16600 < amount
 *
 * 3.异步查询，当金额为 1611 时，异步处理失败(金额单位 为 分)
 *
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/03/26 10:26
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.ChinaumsRefundService, desc = "银商交易退款", owner = "ck.wu")
public class ChinaumsRefundServices extends
        AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {
    
    @Autowired
    MockDepositOrderDao mockDepositOrderDao;
    @Autowired
    MockDepositOrderService mockDepositOrderService;
    @Resource
    MockRequestOrderBase mockRequestOrderBase;
    
    /**
     *
     * 银商交易退款
     *
     * @param request
     * @param result
     */
    @Override
    public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
        try {
            MockDepositOrder mockDepositOrder = new MockDepositOrder();
            Map<String, String> requestMap = Servlets.getParameters(request);
            log.info("MOCK-请求-银商交易退款-请求订单 ： {}", request);
    
            mockDepositOrder = (MockDepositOrder) mapToObject(requestMap, mockDepositOrder.getClass());
            mockRequestOrderBase.initChinaumsRefundServiceOrder(result.getRequestData(),mockDepositOrder);
            long amount = mockDepositOrder.getAmount();
            JSONObject requestData = new JSONObject();
        
            if(amount == 0){
                MockDepositOrder mockDepositOrderUpdate =  mockDepositOrderDao
                        .findEntityByBizOrderNoAndNotifyStatus(mockDepositOrder.getBizOrderNo()).get(0);
                
                if(mockDepositOrderUpdate == null){
                    return;
                }
                mockDepositOrderUpdate.setBizOrderNo(mockDepositOrderUpdate.getBizOrderNo());
                if( amount == 1611 ){
                    requestData.put("code", "SUCCESS");
                    requestData.put("paySt", "FAIL");
                    requestData.put("timestamp", getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
                    
                    mockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
                    mockDepositOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
                } else {
                    requestData.put("code", "SUCCESS");
                    requestData.put("paySt", "SUCCESS");
                    requestData.put("timestamp", getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
                    
                    mockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
                    mockDepositOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
                }
                mockDepositOrderUpdate.setMockNotifyCount(mockDepositOrderUpdate.getMockNotifyCount() + 1);
    
                mockDepositOrderService.updateMockDepositOrder(mockDepositOrderUpdate);
            } else {
                MockDepositOrder mockDepositOrderUpdate =  mockDepositOrderDao
                        .findEntityByBizOrderNoAndNotifyStatus(mockDepositOrder.getBizOrderNo()).get(0);
            
                if( getDateFormatss(mockDepositOrderUpdate.getCreateTime()) ){
                    requestData.put("code", "SUCCESS");
                    requestData.put("paySt", "SUCCESS");
                    requestData.put("timestamp", getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
                    
                    mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
                } else {
                    if( MockUtils.hundreds(amount) == 0 ){
                        requestData.put("code", "FAIL");
                        requestData.put("paySt", "FAIL");
                        requestData.put("timestamp", getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
                        
                        mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
                    } else if( MockUtils.hundreds(amount) == 1 ){
                        requestData.put("code", "SUCCESS");
                        requestData.put("paySt", "SUCCESS");
                        requestData.put("timestamp", getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
                        
                        mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
                    } else {
                        requestData.put("code", "SUCCESS");
                        requestData.put("paySt", "PROCESSING");
                        requestData.put("timestamp", getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
                        
                        mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
                    }
                    mockDepositOrder.setTypeSource(TypeSourceEnum.CHI_WECHAT_WEB_PAY_REFUND.code());
                    mockDepositOrderService.saveMockDepositOrder(mockDepositOrder);
                }
            }
    
            result.setData(requestData);
            log.info("MOCK-银商交易退款 - 应答 requestResult ： {}", result);
        } catch (Exception e) {
            log.error("MOCK-银商交易退款-异常，错误信息:{}", e);
        }
    }
}
