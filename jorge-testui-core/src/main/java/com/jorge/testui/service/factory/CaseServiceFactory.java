package com.jorge.testui.service.factory;

import com.jorge.testui.service.base.CaseService;
import com.jorge.testui.service.base.MockGatewayService;

import java.util.Map;

public interface CaseServiceFactory {

  CaseService getCaseService(String caseNo);

  Map<String , String> getCaseApiRequestMap();

  MockGatewayService getMockGatewayService(String serviceName);
}
