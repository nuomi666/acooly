package com.jorge.testui.mock.gateway.fmbank.trade;

import com.acooly.core.utils.Servlets;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.enums.GatewayChannelApiEnum;
import com.jorge.testui.mock.gateway.MockUtils;
import com.jorge.testui.mock.web.common.result.MockResponseResult;
import com.jorge.testui.service.base.AbstractMockGatewayService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-04-13 17:26
 */
@Slf4j
@MockGatewayAnnotationService(gatewayApi = GatewayChannelApiEnum.FMPayAlipayNativeService, desc = "富民支付宝扫码支付服务", owner = "mufanglin")
public class FMPayAlipayNativeServices extends
        AbstractMockGatewayService<HttpServletRequest, MockResponseResult> {

    @Override
    public void executeGateway(HttpServletRequest request, MockResponseResult result) throws Exception {
        Map<String, String> requestMap = Servlets.getParameters(request);
        log.info("MOCK-请求-富民支付宝扫码支付服务-请求订单 ： {}", result.getRequestData());

        JSONObject jsonObject = JSONObject.parseObject(result.getRequestData());
        JSONObject data = jsonObject.getJSONObject("data");
        Long amount = Long.valueOf(data.getString("amount"));

        JSONObject requestData = new JSONObject();
        if (MockUtils.hundreds(amount) == 1){
            requestData.put("code", "10000");
            requestData.put("codeUrl", "www.baidu.com");
            requestData.put("msg", "直接成功");
        }else if (MockUtils.hundreds(amount) == 0){
            requestData.put("code", "99999");
            requestData.put("codeUrl", "www.baidu.com");
            requestData.put("msg", "直接失败");
        }else {
            requestData.put("code", "10000");
            requestData.put("codeUrl", "www.baidu.com");
            requestData.put("msg", "处理中");
        }
        result.setData(requestData);
        log.info("MOCK-请求-富民支付宝扫码支付服务-响应订单 ： {}", result.getData());
    }
}
