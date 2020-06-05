package com.jorge.testui.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.collect.Maps;
import com.jorge.testui.message.ApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-07-25 17:07
 */
@Slf4j
public class HttpUtil {
    public static Logger logger			= LoggerFactory.getLogger(HttpUtil.class);

    /**
     * openapi5.0框架使用
     *
     * @param url
     * @param map
     * @param securityCheckKey
     * @param accessKey
     * @return
     */
    public static JSONObject httpRequest1(String url, Map<String, Object> map,
                                         String securityCheckKey, String accessKey) {
        String responseBody;
        LinkedHashMap logHeader;
        String body = JSONObject.toJSONString(map);
        Map<String, String> requestHeader = Maps.newTreeMap();
        requestHeader.put("x-api-accessKey", accessKey);
        requestHeader.put("x-api-signType", "MD5");
        requestHeader.put("x-api-sign", sign(body, securityCheckKey));
        logger.info("请求-> header:{} body:{}", requestHeader, body);

        HttpRequest httpRequest = HttpRequest.post(url).headers(requestHeader)
                .contentType("application/json").followRedirects(false).send(body);
        Map<String, List<String>> responseHeader = httpRequest.headers();
        responseBody = httpRequest.body();
        logHeader = Maps.newLinkedHashMap();
        logHeader.put("x-api-signType", responseHeader.get("x-api-signType"));
        logHeader.put("x-api-sign", responseHeader.get("x-api-sign"));
        logger.info("响应-> header:{}, body:{}", logHeader, responseBody);
        JSONObject jsonObject = JSON.parseObject(responseBody);
        logger.info("响应body:{}", jsonObject);

        return jsonObject;
    }


    /**
     * openapi5.0框架使用
     *
     * @param request
     * @param map
     * @return
     */
    public static JSONObject httpRequest(ApiRequest request, Map<String, Object> map
                                         ) {
        String responseBody;
        LinkedHashMap logHeader;
        String body = JSONObject.toJSONString(map);
        Map<String, String> requestHeader = Maps.newTreeMap();
        requestHeader.put("x-api-accessKey", request.getAccessKey());
        requestHeader.put("x-api-signType", "MD5");
        requestHeader.put("x-api-sign", sign(body, request.getSecurityKey()));
        logger.info("请求-> header:{} body:{}", requestHeader, body);

        HttpRequest httpRequest = HttpRequest.post(request.getGatewayUrl()).headers(requestHeader)
                .contentType("application/json").followRedirects(false).send(body);
        Map<String, List<String>> responseHeader = httpRequest.headers();
        responseBody = httpRequest.body();
        logHeader = Maps.newLinkedHashMap();
        logHeader.put("x-api-signType", responseHeader.get("x-api-signType"));
        logHeader.put("x-api-sign", responseHeader.get("x-api-sign"));
        logger.info("响应-> header:{}, body:{}", logHeader, responseBody);
        JSONObject jsonObject = JSON.parseObject(responseBody);
        logger.info("响应body:{}", jsonObject);

        return jsonObject;
    }

    /**
     * 简化入参
     * @param jorgeCommonProperties
     * @param map
     * @return
     */
    public static JSONObject simplifyHttpRequest(JorgeCommonProperties jorgeCommonProperties, Map<String, Object> map) {
        String responseBody;
        LinkedHashMap logHeader;
        String body = JSONObject.toJSONString(map);
        Map<String, String> requestHeader = Maps.newTreeMap();
        requestHeader.put("x-api-accessKey", jorgeCommonProperties.getAccessKey());
        requestHeader.put("x-api-signType", "MD5");
        requestHeader.put("x-api-sign", sign(body, jorgeCommonProperties.getSecretKey()));
        logger.info("请求-> header:{} body:{}", requestHeader, body);

        HttpRequest httpRequest = HttpRequest.post(jorgeCommonProperties.getGatewayurl()).headers(requestHeader)
                .contentType("application/json").followRedirects(false).send(body);
        Map<String, List<String>> responseHeader = httpRequest.headers();
        responseBody = httpRequest.body();
        logHeader = Maps.newLinkedHashMap();
        logHeader.put("x-api-signType", responseHeader.get("x-api-signType"));
        logHeader.put("x-api-sign", responseHeader.get("x-api-sign"));
        logger.info("响应-> header:{}, body:{}", logHeader, responseBody);
        JSONObject jsonObject = JSON.parseObject(responseBody);
        logger.info("响应body:{}", jsonObject);

        return jsonObject;
    }

    public static String sign(String body, String securityCheckKey) {
        return DigestUtils.md5Hex(body + securityCheckKey);
    }

    /**
     * 组装基本参数
     * @param notifyUrl
     * @param returnUrl
     * @param requestNo
     * @param service
     * @param partnerId
     * @param signType
     * @param version
     * @param context
     * @param merchOrderNo
     * @param map
     */
    public static void buildMap1(String notifyUrl, String returnUrl, String requestNo,
                                  String service, String partnerId, String signType, String version,
                                  String context, String merchOrderNo, Map<String, Object> map) {
        map.clear();
        map.put("notifyUrl", notifyUrl);
        map.put("returnUrl", returnUrl);
        map.put("requestNo", requestNo);
        map.put("service", service);
        map.put("partnerId", partnerId);
        map.put("signType", signType);
        map.put("version", version);
        map.put("context", context);
        map.put("merchOrderNo", merchOrderNo);
    }


    /**
     * 简化入参构造
     * @param jorgeCommonProperties
     * @param map
     */
    public static void simplifyBuildMap(JorgeCommonProperties jorgeCommonProperties , Map<String,Object> map){
        map.clear();
        map.put("notifyUrl", jorgeCommonProperties.getNotifyUrl());
        map.put("returnUrl", jorgeCommonProperties.getReturnUrl());
        map.put("requestNo", jorgeCommonProperties.getRequestNo());
        map.put("service", jorgeCommonProperties.getService());
        map.put("partnerId", jorgeCommonProperties.getPartnerId());
        map.put("signType", jorgeCommonProperties.getSingType());
        map.put("version", jorgeCommonProperties.getVersion());
        map.put("context", jorgeCommonProperties.getContext());
        map.put("merchOrderNo", jorgeCommonProperties.getMerchOrderNo());
    }

    /**
     * 简化入参构造
     * @param request
     * @param map
     */
    public static void buildMap(ApiRequest request , Map<String,Object> map){
        map.clear();
        map.put("notifyUrl", request.getNotifyUrl());
        map.put("returnUrl", request.getReturnUrl());
        map.put("requestNo", request.getRequestNo());
        map.put("service", request.getService());
        map.put("partnerId", request.getPartnerId());
        map.put("signType", request.getSingType());
        map.put("version", request.getVersion());
        map.put("context", request.getContext());
        map.put("merchOrderNo", request.getMerchOrderNo());
    }

}
