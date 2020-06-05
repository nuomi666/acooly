/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusWithdrawTransactionService;
import com.jorge.testui.database.gateway.dao.GatewaymusWithdrawTransactionDao;
import com.jorge.testui.database.gateway.entity.GatewaymusWithdrawTransaction;

/**
 * mus_withdraw_transaction Service实现
 *
 * Date: 2019-11-27 11:04:31
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusWithdrawTransactionService")
public class GatewaymusWithdrawTransactionServiceImpl extends EntityServiceImpl<GatewaymusWithdrawTransaction, GatewaymusWithdrawTransactionDao> implements GatewaymusWithdrawTransactionService {

}
