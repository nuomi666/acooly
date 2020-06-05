package com.jorge.testui.mock.gateway.fmbank.trade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

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
 *      acooly.openapi.client.fbank.payolGatewayUrl=http://127.0.0.1:8999/mock/gateway
 *
 * 2.mock银行返回状态说明 (金额单位 为 分)
 *      交易金额 为 ：   失    败： 0 < amount <= 800
 *                      成    功： 800 < amount <= 20600
 *                      处 理 中： 20600 < amount
 *
 * 3.异步查询，当金额为 19816 时，异步处理失败(金额单位 为 分)
 *
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/02/27 14:13
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.QuickPaymentConsumeSms, desc = "富民快捷支付短信申请", owner
		= "ck.wu")
public class FMQuickPaymentConsumeSmsServices extends
		AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {
	
	@Resource
	MockRequestOrderBase mockRequestOrderBase;
	@Autowired
	MockDepositOrderDao mockDepositOrderDao;
	@Autowired
	MockDepositOrderService mockDepositOrderService;
	
	/**
	 *
	 * 富民快捷支付短信申请
	 *
	 * @param request
	 * @param result
	 */
	@Override
	public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
		try {
			MockDepositOrder mockDepositOrder = new MockDepositOrder();
			log.info("MOCK-请求-富民快捷支付短信申请-请求订单 ： {}", request);
			mockRequestOrderBase.initFMQuickPaymentConsumeSmsServiceOrder(result.getRequestData(),
					mockDepositOrder);
			long amount = mockDepositOrder.getAmount();
			JSONObject requestData = new JSONObject();
			
			if(amount == 0){
				MockDepositOrder MockDepositOrderUpdate = new MockDepositOrder();
				MockDepositOrder mockDepositOrderResult = mockDepositOrderDao
											.findEntityByBizOrderNoAndMockStatus(mockDepositOrder.getBizOrderNo());
				if(mockDepositOrderResult == null){
					log.info("MOCK-富民快捷支付短信申请-无定时任务数据可以执行：{}", mockDepositOrderResult);
					new Exception("MOCK-富民快捷支付短信申请-无定时任务数据可以执行");
				}
				MockDepositOrderUpdate.setBizOrderNo(mockDepositOrderResult.getBizOrderNo());
				if( amount == 19816 ){
					requestData.put("code", "00669");
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
				} else {
					requestData.put("code", "2000");
					requestData.put("status", "20");
					
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
				}
				MockDepositOrderUpdate.setMockNotifyCount(mockDepositOrderResult.getMockNotifyCount() + 1);
				
				mockDepositOrderService.updateMockDepositOrder(MockDepositOrderUpdate);
			} else {
				//快捷支付短信申请
				if( MockUtils.hundreds(amount) == 0 ){
					requestData.put("code", "111111");
					requestData.put("message", "快捷支付-失败");
					requestData.put("status", "30");
					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
				} else if( MockUtils.hundreds(amount) == 1 ){
					requestData.put("code", "000000");
					requestData.put("message", "快捷支付-成功");
					requestData.put("status", "20");
	
					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
				} else {
					requestData.put("code", "2000");
					requestData.put("message", "快捷支付-处理中");
					requestData.put("status", "10");
					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
				}
				mockDepositOrderService.saveMockDepositOrder(mockDepositOrder);
			}
			
			result.setData(requestData);
			log.info("MOCK-富民快捷支付短信申请 - 应答 requestResult ： {}", result);
		} catch (Exception e) {
			log.error("MOCK-富民快捷支付短信申请-异常，错误信息:{}", e);
		}
	}
}
