/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-11
 */
package com.jorge.testui.database.openapi.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.openapi.service.ApiOrderInfoService;
import com.jorge.testui.database.openapi.dao.ApiOrderInfoDao;
import com.jorge.testui.database.openapi.entity.ApiOrderInfo;

/**
 * 请求信息表 Service实现
 *
 * Date: 2019-12-11 10:58:11
 *
 * @author mufanglin
 *
 */
@Service("apiOrderInfoService")
public class ApiOrderInfoServiceImpl extends EntityServiceImpl<ApiOrderInfo, ApiOrderInfoDao> implements ApiOrderInfoService {

}
