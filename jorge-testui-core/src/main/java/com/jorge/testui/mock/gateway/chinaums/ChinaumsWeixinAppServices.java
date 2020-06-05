package com.jorge.testui.mock.gateway.chinaums;

import static com.jorge.testui.utils.ClassUtil.mapToObject;
import static com.jorge.testui.utils.DateUtils.getDateFormat;

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
import com.jorge.testui.mock.gateway.MockUtils;
import com.jorge.testui.mock.web.common.base.MockRequestOrderBase;
import com.jorge.testui.mock.web.common.result.MockResponseResult;
import com.jorge.testui.service.base.AbstractMockGatewayService;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 1.需要修改配置(网关)：
 *      acooly.openapi.client.chinaums.payolGatewayUrl=http://127.0.0.1:8999/mock/gateway
 *
 * 2.mock银行返回状态说明 (金额单位 为 分)
 *      交易金额 为 ：   失    败： 0 < amount <= 800
 *                      处 理 中： 800 < amount <= 19600
 *
 * 3.异步查询，当金额为 1619 时，异步处理失败(金额单位 为 分)
 *
 *
 *
 *
 *
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/03/26 10:01
 */

@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.ChinaumsWeixinAppService, desc = "银联商务微信APP支付", owner = "ck.wu")
public class ChinaumsWeixinAppServices extends
		AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {
	
	@Autowired
	MockDepositOrderDao mockDepositOrderDao;
	@Autowired
	MockDepositOrderService mockDepositOrderService;
	
	@Resource
	MockRequestOrderBase mockRequestOrderBase;
	
	/**
	 * 银联商务微信APP支付
	 * @param request
	 * @param result
	 * @throws Exception
	 */
	@Override
	public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
		try {
			MockDepositOrder mockDepositOrder = new MockDepositOrder();
			Map<String, String> requestMap = Servlets.getParameters(request);
			log.info("MOCK-请求-银联商务微信APP支付-请求订单 ： {}", request);
			
			mockDepositOrder = (MockDepositOrder) mapToObject(requestMap, mockDepositOrder.getClass());
			mockRequestOrderBase.initChinaumsWeixinAppServiceOrder(result.getRequestData(),
					mockDepositOrder);
			long amount = mockDepositOrder.getAmount();
			JSONObject requestData = new JSONObject();
			JSONObject data = new JSONObject();
			
			if(amount == 0){
				MockDepositOrder MockDepositOrderUpdate = new MockDepositOrder();
				MockDepositOrder mockDepositOrderUpdate =  mockDepositOrderDao
						.findEntityByBizOrderNoAndNotifyStatus(mockDepositOrder.getBizOrderNo()).get(0);
				
				
				MockDepositOrderUpdate.setBizOrderNo(mockDepositOrderUpdate.getBizOrderNo());
				if( amount == 1619 ){
					data.put("timestamp",new Date());
					requestData.put("code", "00669");
					requestData.put("data", data);
					requestData.put("signData", data);
					result.setCode("00669");
					result.setPaySt("FAIl");
					result.setTimestamp(getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
					result.setPayInfo(requestData);
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
				} else {
					requestData.put("code", "SUCCESS");
					requestData.put("status", "TRADE_SUCCESS");
					requestData.put("totalAmount", mockDepositOrderUpdate.getAmount());
					requestData.put("settleDate", new Date());
					requestData.put("targetOrderId", mockDepositOrderUpdate.getBizOrderNo());
					result.setCode("SUCCESS");
					result.setPaySt("SUCCESS");
					result.setTimestamp(getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
					result.setPayInfo(requestData);
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
				}
				MockDepositOrderUpdate.setMockNotifyCount(mockDepositOrderUpdate.getMockNotifyCount() + 1);
				
				mockDepositOrderService.updateMockDepositOrder(mockDepositOrder);
			} else {
				if( MockUtils.hundreds(amount) == 0 ){
					data.put("timestamp",new Date());
					requestData.put("code", "111111");
					requestData.put("data", data);
					requestData.put("signData", data);
					result.setCode("111111");
					result.setPaySt("SUCCESS");
					result.setTimestamp(getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
					result.setPayInfo(requestData);
					
					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					mockDepositOrder.setMockStatus(MockStatusEnum.FAIL.code());
				} else if( MockUtils.hundreds(amount) == 1 ){
					log.info("成功没有实现，不会直接返回成功！");
				}
				else{
					data.put("appid","wxa5236b4da0bd1596");
					data.put("partnerid",mockDepositOrder.getPartnerId());
					data.put("package","com.cyb.mock");
					data.put("noncestr","rt2");
					data.put("timestamp",new Date());
					
					requestData.put("code", "SUCCESS");
					requestData.put("payInfo", data);
					
					result.setCode("SUCCESS");
					result.setPaySt("SUCCESS");
					result.setTimestamp(getDateFormat(new Date(), "YYYY-MM-dd HH:mm:ss"));
					result.setPayInfo(requestData);
					
					
					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockDepositOrder.setMockStatus(MockStatusEnum.INIT.code());
				}
				mockDepositOrderService.saveMockDepositOrder(mockDepositOrder);
			}
			result.setData(requestData);
			log.info("MOCK-银联商务微信APP支付 - 应答 requestResult ： {}", result);
		} catch (Exception e) {
			log.error("MOCK-银联商务微信APP支付-异常，错误信息:{}", e);
		}
	}
}
