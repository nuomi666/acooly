/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusDepositBackTransactionService;
import com.jorge.testui.database.gateway.dao.GatewaymusDepositBackTransactionDao;
import com.jorge.testui.database.gateway.entity.GatewaymusDepositBackTransaction;

/**
 * mus_deposit_back_transaction Service实现
 *
 * Date: 2019-11-27 11:04:28
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusDepositBackTransactionService")
public class GatewaymusDepositBackTransactionServiceImpl extends EntityServiceImpl<GatewaymusDepositBackTransaction, GatewaymusDepositBackTransactionDao> implements GatewaymusDepositBackTransactionService {

}
