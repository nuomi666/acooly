/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * qiubo@qq.com 2017-07-25 15:00 增加openapi服务路由
 *
 */
package com.jorge.testui.service.factory;

import com.acooly.core.common.exception.BusinessException;
import com.acooly.core.utils.Assert;
import com.acooly.core.utils.GenericsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.enums.GatewayChannelApiEnum;
import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.annotation.CaseApiService;
import com.jorge.testui.service.base.CaseService;
import com.jorge.testui.service.base.MockGatewayService;
import com.jorge.testui.service.route.ServiceRouter;
import com.jorge.testui.utils.JsonExcludeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 用例工厂
 *
 * <p>根据用例命名约定查找spring容器内的服务
 *
 * @author zhike
 */
@Component
public class CaseServiceFactoryImpl  implements CaseServiceFactory, ApplicationContextAware, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(CaseServiceFactoryImpl.class);

    private ApplicationContext applicationContext;

    private Multimap<String, CaseService> servicesMap = null;

    private Map<String,String> apiRequestMap = null;

    private Map<String , MockGatewayService> mockGatewayServiceMap = null;

    @Resource(name = "serviceRouter")
    private ServiceRouter serviceRouter;

    @Override
    public void afterPropertiesSet() throws Exception {
        servicesMap = HashMultimap.create();
        apiRequestMap = new HashMap<>();
        mockGatewayServiceMap = Maps.newHashMap();
        Map<String, CaseService> apiServiceBeansMap =
                applicationContext.getBeansOfType(CaseService.class);

        Map<String, MockGatewayService> mockGatewayServiceBeansMap =
                applicationContext.getBeansOfType(MockGatewayService.class);
        if (apiServiceBeansMap.isEmpty()) {
            logger.warn("测试工程没有对外提供服务");
            return;
        }
        if (mockGatewayServiceBeansMap.isEmpty()){
            logger.warn("测试工程没有对外提供Mock服务");
        }
        for (CaseService apiService : apiServiceBeansMap.values()) {
            registerService(apiService, servicesMap,apiRequestMap);
        }
        for (MockGatewayService mockGatewayService : mockGatewayServiceBeansMap.values()) {
            registerMockService(mockGatewayService, mockGatewayServiceMap);
        }
    }

    private void registerService(CaseService curApiService, Multimap<String, CaseService> servicesMap,Map<String,String> apiRequestMap) {
        CaseApiService openApiService = getOpenApiServiceAnnotation(curApiService);
        if (openApiService == null) {
            throw new RuntimeException(
                    "测试用例"
                            + curApiService.getClass()
                            + "必须要标记com.jorge.testui.annotation.CaseApiService注解");
        }
        checkApiService(curApiService);
        if (servicesMap.containsKey(openApiService.caseNo())) {
            Iterator<CaseService> iterator = servicesMap.get(openApiService.caseNo()).iterator();
            while (iterator.hasNext()) {
                CaseService apiService = iterator.next();
                if (getOpenApiServiceAnnotation(apiService).caseNo().equals(openApiService.caseNo())) {
                    throw new RuntimeException(
                            "用例冲突:" + curApiService.getClass() + "和" + apiService.getClass());
                }
            }
        }
        JsonExcludeFilter filter = new JsonExcludeFilter(curApiService.getRequestBean().getClass(), "caseNo","context","gatewayUrl","success","apiResponse","status","parameterNo");
//        Gson g = new GsonBuilder().serializeNulls().create();
        String apiRequestString = JSON.toJSONString(curApiService.getRequestBean(),filter,SerializerFeature.PrettyFormat,SerializerFeature.PrettyFormat,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteMapNullValue);
//        String apiRequestString = g.toJson(curApiService.getRequestBean());
        apiRequestMap.put(openApiService.caseNo(),apiRequestString);
        logger.info("用例caseNo={}请求报文：{}",openApiService.caseNo(),apiRequestString);
        servicesMap.put(openApiService.caseNo(), curApiService);
        logger.info(
                "加载测试用例[{}] {} {}",
                openApiService.desc(),
                openApiService.caseNo(),
                curApiService.getClass().getName());
    }

    /**
     * 注册Mock网关相关服务
     * @param mockGatewayService
     * @param mockGatewayServiceMap
     */
    private void registerMockService(MockGatewayService mockGatewayService ,Map<String, MockGatewayService> mockGatewayServiceMap){
        MockGatewayAnnotationService mockGatewayAnnotationService = getMockServiceAnnotation(mockGatewayService);
        if (mockGatewayAnnotationService == null){
            throw new RuntimeException(
                    "测试用例"
                            + mockGatewayService.getClass()
                            + "必须要标记com.jorge.testui.annotation.MockGatewayService注解");
        }

        GatewayChannelApiEnum[] channelApiEnums = mockGatewayAnnotationService.gatewayApi();
        for (GatewayChannelApiEnum channelApiEnum : channelApiEnums) {
            if (mockGatewayServiceMap.containsKey(channelApiEnum.getCode())) {
                throw new RuntimeException("网关服务Api冲突:" + mockGatewayService.getClass() + "和" + mockGatewayAnnotationService.getClass());
            }
            mockGatewayServiceMap.put(channelApiEnum.getCode(), mockGatewayService);
            logger.info("加载网关服务[{}] {}: {} {}", mockGatewayAnnotationService.desc(), channelApiEnum, mockGatewayService.getClass().getName());
        }

    }

    private void checkApiService(CaseService curApiService) {
        Class requestClazz = GenericsUtils.getSuperClassGenricType(curApiService.getClass(), 0);
        Class responseClazz = GenericsUtils.getSuperClassGenricType(curApiService.getClass(), 1);
        Assert.isAssignable(CaseBaseRequest.class, requestClazz);
        Assert.isAssignable(CaseBaseResponse.class, responseClazz);
        CaseApiService apiServiceAnnotation = getOpenApiServiceAnnotation(curApiService);
    }

    /**
     * @param caseNo
     * @return
     */
    @Override
    public CaseService getCaseService(String caseNo) {
        Collection<CaseService> apiServices = servicesMap.get(caseNo);
        return serviceRouter.route(caseNo, apiServices);
    }

    private CaseApiService getOpenApiServiceAnnotation(CaseService caseService) {
        return caseService.getClass().getAnnotation(CaseApiService.class);
    }

    private MockGatewayAnnotationService getMockServiceAnnotation(MockGatewayService gatewayService) {
        return gatewayService.getClass().getAnnotation(MockGatewayAnnotationService.class);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Map<String, String> getCaseApiRequestMap() {
        return apiRequestMap;
    }

    @Override
    public MockGatewayService getMockGatewayService(String serviceName) {
        MockGatewayService mockGatewayServices = mockGatewayServiceMap.get(serviceName);
        if (mockGatewayServices == null) {
            throw new BusinessException("mock不支持serviceName[" + serviceName + "]");
        }
        return mockGatewayServices;
    }
}
