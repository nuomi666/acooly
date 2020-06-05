/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusPosTransactionService;
import com.jorge.testui.database.gateway.dao.GatewaymusPosTransactionDao;
import com.jorge.testui.database.gateway.entity.GatewaymusPosTransaction;

/**
 * mus_pos_transaction Service实现
 *
 * Date: 2019-11-27 11:04:30
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusPosTransactionService")
public class GatewaymusPosTransactionServiceImpl extends EntityServiceImpl<GatewaymusPosTransaction, GatewaymusPosTransactionDao> implements GatewaymusPosTransactionService {

}
