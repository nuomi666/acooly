/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusGatewayDeductTransactionService;
import com.jorge.testui.database.gateway.dao.GatewaymusGatewayDeductTransactionDao;
import com.jorge.testui.database.gateway.entity.GatewaymusGatewayDeductTransaction;

/**
 * mus_gateway_deduct_transaction Service实现
 *
 * Date: 2019-11-27 11:04:29
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusGatewayDeductTransactionService")
public class GatewaymusGatewayDeductTransactionServiceImpl extends EntityServiceImpl<GatewaymusGatewayDeductTransaction, GatewaymusGatewayDeductTransactionDao> implements GatewaymusGatewayDeductTransactionService {

}
