package com.jorge.testui.mock.gateway.fmbank.trade;

import static com.jorge.testui.utils.ClassUtil.mapToObject;

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
 *      交易金额 为 ：   失   败 ： 0 < amount <= 800
 *                      成   功 ： 800 < amount <= 19600
 *                      处 理 中： 19600 < amount
 *
 * 3.异步查询，当金额为 19916 时，异步处理失败(金额单位 为 分)
 *
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/04/08 11:25
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FmPaidTransferService, desc = "富民企富通代付转账", owner = "ck.wu")
public class FmPaidTransferServices extends
		AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {
	
	@Resource
	MockRequestOrderBase mockRequestOrderBase;
	@Autowired
	MockDepositOrderDao mockDepositOrderDao;
	@Autowired
	MockDepositOrderService mockDepositOrderService;
	
	/**
	 *
	 * 富民企富通代付转账
	 *
	 * @param request
	 * @param result
	 */
	@Override
	public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
		try {
			MockDepositOrder mockWithdrawOrder = new MockDepositOrder();
			log.info("MOCK-请求-富民企富通代付转账-请求订单 ： {}", request);
			Map<String, String> requestMap = Servlets.getParameters(request);
			mockWithdrawOrder = (MockDepositOrder) mapToObject(requestMap, mockWithdrawOrder.getClass());
			
			mockRequestOrderBase.initFmPaidTransferServiceOrder(result.getRequestData(), mockWithdrawOrder);
			long amount = mockWithdrawOrder.getAmount();
			JSONObject requestData = new JSONObject();
			JSONObject data = new JSONObject();
			if(amount == 0){
				MockDepositOrder MockDepositOrderUpdate = new MockDepositOrder();
				MockDepositOrder mockDepositOrderResult = mockDepositOrderDao
						.findEntityByBizOrderNoAndMockStatus(mockWithdrawOrder.getBizOrderNo());
				
				MockDepositOrderUpdate.setBizOrderNo(mockDepositOrderResult.getBizOrderNo());
				if( amount == 19916 ){
					requestData.put("code", "00669");
					requestData.put("data", data);
					requestData.put("signData", data);
					requestData.put("message", "err");
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
				} else {
					requestData.put("code", "10000");
					requestData.put("payInfo", data);
					requestData.put("signData", data);
					requestData.put("paySt","2");
					requestData.put("message", "success");
					requestData.put("amount", String.valueOf(mockDepositOrderResult.getAmount()));
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
				}
				MockDepositOrderUpdate.setMockNotifyCount(mockDepositOrderResult.getMockNotifyCount() + 1);
				
				mockDepositOrderService.updateMockDepositOrder(MockDepositOrderUpdate);
			} else {
				if( MockUtils.hundreds(amount) == 0 ){
					requestData.put("status", "09");
					requestData.put("accFlowNo", data);
					requestData.put("code", "000011");
					requestData.put("message", "err");
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					mockWithdrawOrder.setMockStatus(MockStatusEnum.FAIL.code());
					mockWithdrawOrder.setConfirmStatus(ConfirmStatusEnum.FAIL.code());
				} else if( MockUtils.hundreds(amount) == 1 ){
					requestData.put("status", "00");
					requestData.put("accFlowNo", data);
					requestData.put("code", "000000");
					requestData.put("message", "success");
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockWithdrawOrder.setMockStatus(MockStatusEnum.SUCCESS.code());
					mockWithdrawOrder.setConfirmStatus(ConfirmStatusEnum.SUCCESS.code());
				} else {
					requestData.put("status", "02");
					requestData.put("accFlowNo", data);
					requestData.put("code", "000000");
					requestData.put("message", "apply");
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockWithdrawOrder.setMockStatus(MockStatusEnum.PROCESSING.code());
					mockWithdrawOrder.setConfirmStatus(ConfirmStatusEnum.PROCESSING.code());
				}
				mockDepositOrderService.saveMockDepositOrder(mockWithdrawOrder);
			}
			
			result.setData(requestData);
			log.info("MOCK-富民企富通代付转账 - 应答 requestResult ： {}", request);
		} catch (Exception e) {
			log.error("MOCK-富民企富通代付转账应答-异常，错误信息:{}", e);
		}
	}
}
