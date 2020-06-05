package com.jorge.testui.mock.gateway.fmbank.sign;

import com.acooly.core.utils.Servlets;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.database.mock.dao.MockSignInfoDao;
import com.jorge.testui.database.mock.entity.MockSignInfo;
import com.jorge.testui.database.mock.service.MockSignInfoService;
import com.jorge.testui.enums.GatewayChannelApiEnum;
import com.jorge.testui.enums.MockNotifyStatusEnum;
import com.jorge.testui.enums.MockStatusEnum;
import com.jorge.testui.mock.web.common.base.MockRequestOrderBase;
import com.jorge.testui.mock.web.common.result.MockResponseResult;
import com.jorge.testui.service.base.AbstractMockGatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
 * @Author zhoudl
 * @Email 331574553@qq.com
 * @History create 2020/04/10 10:44
 * // TODO
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FmQuickPaymentSignQueryService, desc = "富民快捷绑卡查询", owner = "ck.wu")
public class FmQuickPaymentSignQueryServices extends
		AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {

	@Resource
	MockRequestOrderBase mockRequestOrderBase;

	@Resource
	MockSignInfoDao mockSignInfoDao;

	@Autowired
	MockSignInfoService mockSignInfoService;

	@Override
	public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
		
		try {
			MockSignInfo mockSignInfo = new MockSignInfo();
			log.info("MOCK-请求-富民快捷綁卡查询-请求订单 ： {}", request);
			Map<String, String> requestMap = Servlets.getParameters(request);
			mockSignInfo = (MockSignInfo) mapToObject(requestMap, mockSignInfo.getClass());
			
			mockRequestOrderBase.initFmQuickPaymentSignQueryOrder(result.getRequestData(), mockSignInfo);
			String bankCardNo = mockSignInfo.getBankCardNo();
			JSONObject requestData = new JSONObject();
			MockSignInfo mockSignInfoUpdate = new MockSignInfo();

			mockSignInfoUpdate.setBizOrderNo(mockSignInfoUpdate.getBizOrderNo());
			if("2".equals(bankCardNo.substring(bankCardNo.length()-1))){
				requestData.put("code", "000011");
				requestData.put("message", "申请失败");
				requestData.put("accNo", bankCardNo);
				requestData.put("activateStatus","0");
				mockSignInfo.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
				mockSignInfo.setMockStatus(MockStatusEnum.FAIL.code());
			} else {
				requestData.put("code", "000000");
				requestData.put("message", "交易成功");
				requestData.put("accNo",bankCardNo);
				requestData.put("activateStatus","1");
				mockSignInfo.setMockNotifyStatus(MockNotifyStatusEnum.S.code());
				mockSignInfo.setMockStatus(MockStatusEnum.SUCCESS.code());
			}
			mockSignInfoService.updateMockSignInfoOrder(mockSignInfoUpdate);

			result.setData(requestData);
			log.info("MOCK-富民快捷綁卡查询 - 应答 requestResult ： {}", request);
		} catch (Exception e) {
			log.error("MOCK-富民快捷綁卡查询-异常，错误信息:{}", e);
		}
		
	}
}
