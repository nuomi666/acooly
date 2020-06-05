package com.jorge.testui.mock.gateway.fmbank.trade;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.acooly.core.utils.Money;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.database.mock.dao.MockDepositOrderDao;
import com.jorge.testui.database.mock.dao.MockWithdrawOrderDao;
import com.jorge.testui.database.mock.entity.MockWithdrawOrder;
import com.jorge.testui.database.mock.service.MockDepositOrderService;
import com.jorge.testui.database.mock.service.MockWithdrawOrderService;
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
 *
 * 1.需要修改配置(网关)：
 *      acooly.openapi.client.fbank.payolGatewayUrl=http://127.0.0.1:8999/mock/gateway
 *
 * 2.mock银行返回状态说明 (金额单位 为 分)
 *      交易金额 为 ：   失   败 ： 0 < amount <= 800
 *                      成   功 ： 800 < amount <= 19600
 *                      处 理 中： 19600 < amount
 *
 * 3.异步查询，当金额为 19816 时，异步处理失败(金额单位 为 分)
 *
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/03/11 15:21
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FmAccountIIWithdrawService, desc = "富民二类账户资金转出", owner = "ck.wu")
public class FmAccountIIWithdrawServices extends
		AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {
	
	@Resource
	MockRequestOrderBase mockRequestOrderBase;
	@Autowired
	MockDepositOrderDao mockDepositOrderDao;
	@Autowired
	MockDepositOrderService mockDepositOrderService;
	
	@Autowired
	MockWithdrawOrderDao mockWithdrawOrderDao;
	@Autowired
	MockWithdrawOrderService mockWithdrawOrderService;
	
	/**
	 *
	 * 富民二类账户资金转出
	 *
	 * @param request
	 * @param result
	 */
	@Override
	public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
		try {
			MockWithdrawOrder mockWithdrawOrder;
			mockWithdrawOrder = new MockWithdrawOrder();
			log.info("MOCK-请求-富民二类账户资金转出-请求订单 ： {}", request);
			mockRequestOrderBase.initFmAccountIIWithdrawServiceOrder(result.getRequestData(),mockWithdrawOrder);
			long amount = mockWithdrawOrder.getAmount();
			JSONObject requestData = new JSONObject();
			
			if(amount == 0){
				MockWithdrawOrder MockWithdrawOrderUpdate = new MockWithdrawOrder();
				MockWithdrawOrder mockWithdrawOrderResult = mockWithdrawOrderDao.findEntityByBizOrderNoAndTypeSource(mockWithdrawOrder
																	.getBizOrderNo(),TypeSourceEnum.FM_II_WITHDRAW.code());
				if(mockWithdrawOrderResult == null){
					log.info("MOCK-富民二类账户资金转出：{}", mockWithdrawOrderResult);
					new Exception("MOCK-富民二类账户资金转出");
				}
				amount = mockWithdrawOrderResult.getAmount();
				MockWithdrawOrderUpdate.setBizOrderNo(mockWithdrawOrderResult.getBizOrderNo());
				if( 2<= MockUtils.hundreds(amount) && MockUtils.hundreds(amount)<= 4 ){
					requestData.put("code", "000000");
					requestData.put("tradeStatus", "111");
					requestData.put("paymentMsg", "fail");
					requestData.put("paymentCode", "111");
					MockWithdrawOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					MockWithdrawOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
				} else {
					requestData.put("code", "000000");
					requestData.put("status", "20");
					requestData.put("message", "success");
					requestData.put("amount", Money.cent(mockWithdrawOrderResult.getAmount()).toString());
					requestData.put("settleDate", new Date());
					requestData.put("tradeStatus", "1");
					requestData.put("paymentMsg", "success");
					requestData.put("finishTime", new Date());
					requestData.put("tradeNo", mockWithdrawOrderResult.getBizOrderNo());
					requestData.put("paymentCode", "1");
					requestData.put("targetOrderId", mockWithdrawOrderResult.getBizOrderNo());
					
					MockWithdrawOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
					MockWithdrawOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
				}
				MockWithdrawOrderUpdate.setId(mockWithdrawOrderResult.getId());
				MockWithdrawOrderUpdate.setMockNotifyCount(mockWithdrawOrderResult.getMockNotifyCount() + 1);
				mockWithdrawOrderService.updateMockWithdrawOrder(MockWithdrawOrderUpdate);
			} else {
				if( MockUtils.hundreds(amount) == 0 ){
					requestData.put("code", "111111");
					requestData.put("message", "富民二类账户资金转出-失败");
					requestData.put("status", "30");
					requestData.put("bankSerialNo", mockWithdrawOrder.getPayBankId());
					
					mockWithdrawOrder.setMockStatus(MockStatusEnum.FAIL.code());
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
				} else if( MockUtils.hundreds(amount) == 1 ){
					requestData.put("code", "000000");
					requestData.put("message", "富民二类账户资金转出-成功");
					requestData.put("status", "1");
					requestData.put("bankSerialNo", mockWithdrawOrder.getPayBankId());
					
					mockWithdrawOrder.setMockStatus(MockStatusEnum.SUCCESS.code());
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
				} else {
					requestData.put("code", "000000");
					requestData.put("message", "富民二类账户资金转出-处理中");
					requestData.put("status", "0");
					requestData.put("bankSerialNo", mockWithdrawOrder.getPayBankId());
					
					mockWithdrawOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockWithdrawOrder.setMockStatus(MockStatusEnum.PROCESSING.code());
				}
				mockWithdrawOrder.setTypeSource(TypeSourceEnum.FM_II_WITHDRAW.code());
				mockWithdrawOrderService.saveMockWithdrawOrder(mockWithdrawOrder);
			}
			
			result.setData(requestData);
			log.info("MOCK-富民二类账户资金转出 - 应答 requestResult ： {}", result);
		} catch (Exception e) {
			log.error("MOCK-富民二类账户资金转出-异常，错误信息:{}", e);
		}
	}
	
}
