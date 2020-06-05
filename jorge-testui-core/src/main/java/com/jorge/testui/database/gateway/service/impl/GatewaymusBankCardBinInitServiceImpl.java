/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusBankCardBinInitService;
import com.jorge.testui.database.gateway.dao.GatewaymusBankCardBinInitDao;
import com.jorge.testui.database.gateway.entity.GatewaymusBankCardBinInit;

/**
 * 卡BIN信息表 Service实现
 *
 * Date: 2019-11-27 11:04:27
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusBankCardBinInitService")
public class GatewaymusBankCardBinInitServiceImpl extends EntityServiceImpl<GatewaymusBankCardBinInit, GatewaymusBankCardBinInitDao> implements GatewaymusBankCardBinInitService {

}
