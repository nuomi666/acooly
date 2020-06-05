package com.jorge.testui.mock.gateway.fmbank.sign;

import com.acooly.core.utils.Servlets;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.database.mock.dao.MockDepositOrderDao;
import com.jorge.testui.database.mock.dao.MockSignInfoDao;
import com.jorge.testui.database.mock.entity.MockDepositOrder;
import com.jorge.testui.database.mock.entity.MockSignInfo;
import com.jorge.testui.database.mock.service.MockDepositOrderService;
import com.jorge.testui.database.mock.service.MockSignInfoService;
import com.jorge.testui.enums.ConfirmStatusEnum;
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
 * @Author zhoudl
 * @Email 331574553@qq.com
 * @History create 2020/04/10 10:44
 * // TODO
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FmQuickPaymentSignService, desc = "富民快捷绑卡", owner = "zdl")
public class FmQuickPaymentSignServices extends
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
			log.info("MOCK-请求-富民快捷綁卡-请求订单 ： {}", request);
			Map<String, String> requestMap = Servlets.getParameters(request);
			mockSignInfo = (MockSignInfo) mapToObject(requestMap, mockSignInfo.getClass());
			
			mockRequestOrderBase.initFmQuickPaymentSignOrder(result.getRequestData(), mockSignInfo);
			String bankCardNo = mockSignInfo.getBankCardNo();
			JSONObject requestData = new JSONObject();
//			JSONObject data = new JSONObject();
			MockSignInfo mockSignInfoUpdate = new MockSignInfo();
//			MockSignInfo mockSignInfoResult = mockSignInfoDao.findEntityByBizOrderNoAndMockStatus(mockSignInfo.getBizOrderNo());

			mockSignInfoUpdate.setBizOrderNo(mockSignInfoUpdate.getBizOrderNo());
			if("2".equals(bankCardNo.substring(bankCardNo.length()-1))){
				requestData.put("code", "000011");
				requestData.put("message", "申请失败");
				requestData.put("formHtml", "");
				mockSignInfo.setMockNotifyStatus(MockNotifyStatusEnum.F.code());
				mockSignInfo.setMockStatus(MockStatusEnum.FAIL.code());
			} else {
				requestData.put("code", "000000");
				requestData.put("message", "交易成功");
				requestData.put("formHtml","<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body><form id = \"pay_form\" action=\"https://gateway.test.95516.com/gateway/api/frontTransReq.do\" method=\"post\"><input type=\"hidden\" name=\"bizType\" id=\"bizType\" value=\"000902\"/><input type=\"hidden\" name=\"tokenPayData\" id=\"tokenPayData\" value=\"{trId=99988877766&tokenType=01}\"/><input type=\"hidden\" name=\"txnSubType\" id=\"txnSubType\" value=\"00\"/><input type=\"hidden\" name=\"orderId\" id=\"orderId\" value=\"20031200462900693542\"/><input type=\"hidden\" name=\"backUrl\" id=\"backUrl\" value=\"https://opensandbox.fbank.com/pm2/opencallback/callback/passthrough/up4opencard\"/><input type=\"hidden\" name=\"signature\" id=\"signature\" value=\"da2ONmfe3I7mQptrzL+vp8WkldltclzPuq6eI1HoJBxzUFz9P9S0KSHaTwnokLcR9zs+rEfNXStw4j0w0qV4peaiVxM0M8Y8XwAzPGQKVx3vHfLi3+QCbeoUQVMyw/VN2YKzO3nMy/RaF2Olzpxzv9orEpAtR0TbJDkhcgPOjf9g9LAFJng/vO5SkCM4JZGnpNAEyvny+d78YohX0cSPtC36DqSHjkmox8QWbDCzapXlEOps42CVRjT3wLNYGsgAZpOrajJBJdA6KFFUTtBxQfK7C4pSKMA7mqXIYtgSkpf8NLkRruN5UNzS9J0i6gbDpbjpytLtI/TUtqvitvKCAA==\"/><input type=\"hidden\" name=\"accNo\" id=\"accNo\" value=\"K4dSoVPmOHGFwO5MSDvvREIW19na+Nkike6r4ZrHB6m1eZZ+cbgob08x6eQ/ZWjiAmlo+TL3zzIW44GwQXLArl/unNA1TlzHTqIV8kFE8sdB1y24cyfs0vqDUf0tc1NSCsxZF+VkVdv97/tqgb72sFq/Lmk5Pi/HuqZT7CUkunOTpKFthOAM6NWkH3WOUis3gIKO1cXGh58pyDdCB09fvi/qR6Qi18Up9GU+Me+mdlWdGpLHmtLO3/oOEe718xXb6OEXl6oh2b78PNT8N09qQmu9DuNgFTpwdAKnAuiiFB2WIzDEPcH9rilRlgL4NFfpQWjUw7DXSahyh2wjXFSTXw==\"/><input type=\"hidden\" name=\"customerInfo\" id=\"customerInfo\" value=\"e2NlcnRpZklkPTE1MDQyOTE5ODYwNjE1MjEyNiZjZXJ0aWZUcD0wMSZjdXN0b21lck5tPeWui+Wwj30=\"/><input type=\"hidden\" name=\"channelType\" id=\"channelType\" value=\"07\"/><input type=\"hidden\" name=\"txnType\" id=\"txnType\" value=\"79\"/><input type=\"hidden\" name=\"frontUrl\" id=\"frontUrl\" value=\"http://127.0.0.1:8999\"/><input type=\"hidden\" name=\"certId\" id=\"certId\" value=\"68759663125\"/><input type=\"hidden\" name=\"encoding\" id=\"encoding\" value=\"UTF-8\"/><input type=\"hidden\" name=\"version\" id=\"version\" value=\"5.1.0\"/><input type=\"hidden\" name=\"accessType\" id=\"accessType\" value=\"0\"/><input type=\"hidden\" name=\"encryptCertId\" id=\"encryptCertId\" value=\"69026275926\"/><input type=\"hidden\" name=\"txnTime\" id=\"txnTime\" value=\"20200312004838\"/><input type=\"hidden\" name=\"merId\" id=\"merId\" value=\"346502259333996\"/><input type=\"hidden\" name=\"accType\" id=\"accType\" value=\"01\"/><input type=\"hidden\" name=\"signMethod\" id=\"signMethod\" value=\"01\"/></form></body><script type=\"text/javascript\">document.all.pay_form.submit();</script></html>");
				mockSignInfo.setMockNotifyStatus(MockNotifyStatusEnum.N.code());
				mockSignInfo.setMockStatus(MockStatusEnum.PROCESSING.code());
			}
			mockSignInfoService.updateMockSignInfoOrder(mockSignInfoUpdate);

			result.setData(requestData);
			log.info("MOCK-富民快捷绑卡 - 应答 requestResult ： {}", request);
		} catch (Exception e) {
			log.error("MOCK-富民快捷绑卡-异常，错误信息:{}", e);
		}
		
	}
}
