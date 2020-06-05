package com.jorge.testui.mock.gateway.fmbank.trade;

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
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import static com.jorge.testui.utils.ClassUtil.mapToObject;

/**
 *
 * 1.需要修改配置(网关)：
 *      acooly.openapi.client.mock.gatewayUrl=http://127.0.0.1:8999/mock/gateway
 *
 * 2.mock银行返回状态说明 (金额单位 为 分)
 *      交易金额 为 ：   失   败 ： 0 < amount <= 600
 *                      成   功 ： 600 < amount <= 6600
 *                      处 理 中： 6600 < amount
 *
 * 3.异步查询，当金额为 19816 时，异步处理失败(金额单位 为 分)
 *
 *
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/04/09 10:44
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FmConsumeLedgerService, desc = "富民企富通商户消费分账", owner = "ck.wu")
public class FmConsumeLedgerServices extends
		AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {
	
	@Resource
	MockRequestOrderBase mockRequestOrderBase;
	@Autowired
	MockDepositOrderDao mockDepositOrderDao;
	@Autowired
	MockDepositOrderService mockDepositOrderService;
	
	@Override
	public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
		
		try {
			MockDepositOrder mockWithdrawOrder = new MockDepositOrder();
			log.info("MOCK-请求-富民企富通商户消费分账-请求订单 ： {}", request);
			Map<String, String> requestMap = Servlets.getParameters(request);
			mockWithdrawOrder = (MockDepositOrder) mapToObject(requestMap, mockWithdrawOrder.getClass());
			
			mockRequestOrderBase.initFmConsumeLedgerServiceOrder(result.getRequestData(), mockWithdrawOrder);
			long amount = mockWithdrawOrder.getAmount();
			JSONObject requestData = new JSONObject();
			JSONObject data = new JSONObject();
			if(amount == 0){
				MockDepositOrder MockDepositOrderUpdate = new MockDepositOrder();
				MockDepositOrder mockDepositOrderResult = mockDepositOrderDao
						.findEntityByBizOrderNoAndMockStatus(mockWithdrawOrder.getBizOrderNo());
				
				MockDepositOrderUpdate.setBizOrderNo(mockDepositOrderResult.getBizOrderNo());
				if( 2<= MockUtils.hundreds(amount) && MockUtils.hundreds(amount)<= 4 ){
					requestData.put("code", "90669");
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
				if(MockUtils.hundreds(amount) == 0){
					requestData.put("status", "99");
					requestData.put("accFlowNo", data);
					requestData.put("code", "000011");
					requestData.put("message", "err");
					requestData.put("tradeDate", new Date());
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					mockWithdrawOrder.setMockStatus(MockStatusEnum.FAIL.code());
					mockWithdrawOrder.setConfirmStatus(ConfirmStatusEnum.FAIL.code());
				} else if( MockUtils.hundreds(amount) == 1 ){
					requestData.put("status", "1");
					requestData.put("accFlowNo", data);
					requestData.put("code", "000000");
					requestData.put("message", "success");
					requestData.put("tradeDate", new Date());
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockWithdrawOrder.setMockStatus(MockStatusEnum.SUCCESS.code());
					mockWithdrawOrder.setConfirmStatus(ConfirmStatusEnum.SUCCESS.code());
				} else {
					requestData.put("status", "0");
					requestData.put("accFlowNo", data);
					requestData.put("code", "000000");
					requestData.put("message", "apply");
					requestData.put("tradeDate", new Date());
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockWithdrawOrder.setMockStatus(MockStatusEnum.PROCESSING.code());
					mockWithdrawOrder.setConfirmStatus(ConfirmStatusEnum.PROCESSING.code());
				}
				mockDepositOrderService.saveMockDepositOrder(mockWithdrawOrder);
			}
			
			result.setData(requestData);
			log.info("MOCK-富民企富通商户消费分账 - 应答 requestResult ： {}", request);
		} catch (Exception e) {
			log.error("MOCK-富民企富通商户消费分账-异常，错误信息:{}", e);
		}
		
	}
}
