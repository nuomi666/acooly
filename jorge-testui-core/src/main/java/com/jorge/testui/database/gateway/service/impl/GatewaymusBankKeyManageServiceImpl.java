/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusBankKeyManageService;
import com.jorge.testui.database.gateway.dao.GatewaymusBankKeyManageDao;
import com.jorge.testui.database.gateway.entity.GatewaymusBankKeyManage;

/**
 * 银行密钥管理 Service实现
 *
 * Date: 2019-11-27 11:04:27
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusBankKeyManageService")
public class GatewaymusBankKeyManageServiceImpl extends EntityServiceImpl<GatewaymusBankKeyManage, GatewaymusBankKeyManageDao> implements GatewaymusBankKeyManageService {

}
