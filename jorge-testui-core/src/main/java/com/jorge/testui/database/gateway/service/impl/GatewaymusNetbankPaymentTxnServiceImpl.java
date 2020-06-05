/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusNetbankPaymentTxnService;
import com.jorge.testui.database.gateway.dao.GatewaymusNetbankPaymentTxnDao;
import com.jorge.testui.database.gateway.entity.GatewaymusNetbankPaymentTxn;

/**
 * mus_netbank_payment_txn Service实现
 *
 * Date: 2019-11-27 11:04:29
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusNetbankPaymentTxnService")
public class GatewaymusNetbankPaymentTxnServiceImpl extends EntityServiceImpl<GatewaymusNetbankPaymentTxn, GatewaymusNetbankPaymentTxnDao> implements GatewaymusNetbankPaymentTxnService {

}
