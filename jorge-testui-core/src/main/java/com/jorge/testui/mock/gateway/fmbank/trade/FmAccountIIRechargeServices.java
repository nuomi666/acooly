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
import com.jorge.testui.database.mock.entity.MockDepositOrder;
import com.jorge.testui.database.mock.entity.MockWithdrawOrder;
import com.jorge.testui.database.mock.service.MockDepositOrderService;
import com.jorge.testui.database.mock.service.MockWithdrawOrderService;
import com.jorge.testui.enums.*;
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
 * @History create 2020/03/10 17:41
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FmAccountIIRechargeService, desc = "富民II类户资金转入", owner = "ck.wu")
public class FmAccountIIRechargeServices extends
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
	 * 富民II类户资金转入
	 *
	 * @param request
	 * @param result
	 */
	@Override
	public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
		MockWithdrawOrder mockWithdrawOrderUpdate = new MockWithdrawOrder();
		try {
			MockDepositOrder mockDepositOrder = new MockDepositOrder();
			MockWithdrawOrder mockWithdrawOrder = new MockWithdrawOrder();
			log.info("MOCK-请求-富民II类户资金转入-请求订单 ： {}", request);
			
			mockRequestOrderBase.initFmAccountIIRechargeServiceOrder(result.getRequestData(),mockDepositOrder);
			mockWithdrawOrder.setBizOrderNo(mockDepositOrder.getBizOrderNo());
			mockRequestOrderBase.initFmAccountIIWithdrawServiceOrder2(result.getRequestData(),mockWithdrawOrder);
			long amount = mockDepositOrder.getAmount();
			JSONObject requestData = new JSONObject();
			
			if(amount == 0){
				MockDepositOrder MockDepositOrderUpdate = new MockDepositOrder();
				MockDepositOrder mockDepositOrderResult =
						mockDepositOrderDao.findEntityByBizOrderNoAndMockStatus(mockDepositOrder.getBizOrderNo());
				
				MockWithdrawOrder mockWithdrawOrderResult = new MockWithdrawOrder();
				if(mockDepositOrderResult==null){
					mockWithdrawOrderResult = mockWithdrawOrderDao
							.findEntityByBizOrderNoAndTypeSource(mockWithdrawOrder.getBizOrderNo(),TypeSourceEnum.FM_II_WITHDRAW.code());
					
					log.info("MOCK-富民II类户资金转出：{}", mockWithdrawOrderResult);
				}
				amount = mockDepositOrderResult == null ?
						mockWithdrawOrderResult.getAmount() :mockDepositOrderResult.getAmount();
				MockDepositOrderUpdate.setBizOrderNo(mockDepositOrderResult == null ? "0" :
						mockDepositOrderResult.getBizOrderNo());
				mockWithdrawOrderUpdate.setBizOrderNo(mockWithdrawOrderResult == null ? "1" :
						mockWithdrawOrderResult.getBizOrderNo());
				if( 2<= MockUtils.hundreds(amount) && MockUtils.hundreds(amount)<= 4 ){
					requestData.put("code", "000000");
					requestData.put("tradeStatus", "111");
					requestData.put("paymentMsg", "fail");
					requestData.put("paymentCode", "111");
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
					
					mockWithdrawOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					mockWithdrawOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
				} else {
					if(mockDepositOrderResult==null){
						requestData.put("amount", Money.cent(mockWithdrawOrderResult.getAmount()).toString());
						requestData.put("tradeNo", mockWithdrawOrderResult.getBizOrderNo());
						requestData.put("targetOrderId", mockWithdrawOrderResult.getBizOrderNo());
					} else {
						requestData.put("amount", Money.cent(mockDepositOrderResult.getAmount()).toString());
						requestData.put("tradeNo", mockDepositOrderResult.getBizOrderNo());
						requestData.put("targetOrderId", mockDepositOrderResult.getBizOrderNo());
					}
					
					requestData.put("code", "000000");
					requestData.put("message", "success");
					requestData.put("status", "1");
					requestData.put("settleDate", new Date());
					requestData.put("tradeStatus", "1");
					requestData.put("paymentMsg", "success");
					requestData.put("finishTime", new Date());
					requestData.put("paymentCode", "1");
					
					MockDepositOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
					
					mockWithdrawOrderUpdate.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
					mockWithdrawOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
				}
				MockDepositOrderUpdate.setMockNotifyCount(mockDepositOrderResult == null ? 0:
						mockDepositOrderResult.getMockNotifyCount() + 1);
				mockWithdrawOrderUpdate.setMockNotifyCount(mockWithdrawOrderResult == null
											? 1 :mockWithdrawOrderResult.getMockNotifyCount() + 1);
				if(mockDepositOrderResult==null){
					mockWithdrawOrderUpdate.setSucAmount(mockWithdrawOrderResult.getAmount());
					mockWithdrawOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
					mockWithdrawOrderService.updateMockWithdrawOrder(mockWithdrawOrderUpdate);
				} else {
					MockDepositOrderUpdate.setMockStatus(MockStatusEnum.SUCCESS.code());
					MockDepositOrderUpdate.setConfirmStatus(ConfirmStatusEnum.SUCCESS.code());
					mockDepositOrderService.updateMockDepositOrder(MockDepositOrderUpdate);
				}
				
			} else {
				//富民II类户资金转入
				if( MockUtils.hundreds(amount) == 0 ){
					requestData.put("code", "111111");
					requestData.put("message", "富民II类户资金转入-失败");
					requestData.put("status", "30");
					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
					mockDepositOrder.setMockStatus(MockStatusEnum.FAIL.code());
					mockDepositOrder.setConfirmStatus(ConfirmStatusEnum.FAIL.code());
				} else if( MockUtils.hundreds(amount) == 1 ){
					requestData.put("code", "000000");
					requestData.put("status", "1");
					requestData.put("message", "富民II类户资金转入-成功");
					requestData.put("bankSerialNo", mockDepositOrder.getBankSerialNo());

					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockDepositOrder.setMockStatus(MockStatusEnum.SUCCESS.code());
					mockDepositOrder.setConfirmStatus(ConfirmStatusEnum.SUCCESS.code());
				} else {
					requestData.put("code", "000000");
					requestData.put("status", "0");
					requestData.put("message", "富民II类户资金转入-处理中");
					requestData.put("bankSerialNo", mockDepositOrder.getBankSerialNo());

					mockDepositOrder.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
					mockDepositOrder.setMockStatus(MockStatusEnum.PROCESSING.code());
					mockDepositOrder.setConfirmStatus(ConfirmStatusEnum.PROCESSING.code());
				}
				mockDepositOrderService.saveMockDepositOrder(mockDepositOrder);
			}
			
			result.setData(requestData);
			log.info("MOCK-富民II类户资金转入 - 应答 requestResult ： {}", result);
		} catch (Exception e) {
			mockWithdrawOrderUpdate.setMockStatus(MockStatusEnum.FAIL.code());
			mockWithdrawOrderService.updateMockWithdrawOrder(mockWithdrawOrderUpdate);
			log.error("MOCK-富民II类户资金转入-异常，错误信息:{}", e);
		}
	}
}
