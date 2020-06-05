package com.jorge.testui.test;
import com.acooly.core.utils.Ids;

import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.utils.HttpUtil;
import com.jorge.testui.utils.JorgeCommonProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-12-26 14:39
 */
@Slf4j
public class TradeFacadeTest extends TestBase {
    @Resource
    JorgeCommonProperties jorgeCommonProperties;

    @Test
    public void tradeCancel() {
        JSONObject responseEntity = new JSONObject();
        jorgeCommonProperties.setService("tradeCancel");
        String merchOrderNo = Ids.getDid("test");

        String origMerchOrdeNo = "o19122613572563100172";
        String cancelReason = "一不小心就要撤消";

        Map<String, Object> map = new HashMap<String, Object>();
        HttpUtil.simplifyBuildMap(jorgeCommonProperties,map);

        map.put("merchOrderNo",merchOrderNo);
        map.put("origMerchOrdeNo",origMerchOrdeNo);
        map.put("cancelReason",cancelReason);

        //调用接口
        responseEntity = HttpUtil.simplifyHttpRequest(jorgeCommonProperties,map);




    }


    @Test
    public void tradeRefund() {
        JSONObject responseEntity = new JSONObject();
        jorgeCommonProperties.setService("tradeRefund");
        String merchOrderNo = Ids.getDid("test");

        String origMerchOrdeNo = Ids.getDid("test");
        String refundReason = "一不小心就要退款";
        String refundAmount = "1";

        Map<String, Object> map = new HashMap<String, Object>();

        HttpUtil.simplifyBuildMap(jorgeCommonProperties,map);

        map.put("merchOrderNo",merchOrderNo);
        map.put("origMerchOrdeNo",origMerchOrdeNo);
        map.put("refundAmount",refundAmount);
        map.put("refundReason",refundReason);

        //调用接口
        responseEntity = HttpUtil.simplifyHttpRequest(jorgeCommonProperties, map);


    }
}
