/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusRegisterAccountService;
import com.jorge.testui.database.gateway.dao.GatewaymusRegisterAccountDao;
import com.jorge.testui.database.gateway.entity.GatewaymusRegisterAccount;

/**
 * 注册开户 Service实现
 *
 * Date: 2019-11-27 11:04:30
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusRegisterAccountService")
public class GatewaymusRegisterAccountServiceImpl extends EntityServiceImpl<GatewaymusRegisterAccount, GatewaymusRegisterAccountDao> implements GatewaymusRegisterAccountService {

}
