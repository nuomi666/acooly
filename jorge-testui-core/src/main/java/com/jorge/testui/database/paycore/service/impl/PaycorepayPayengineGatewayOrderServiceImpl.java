/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycorepayPayengineGatewayOrderService;
import com.jorge.testui.database.paycore.dao.PaycorepayPayengineGatewayOrderDao;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineGatewayOrder;

/**
 * 支付引擎网关订单表 Service实现
 *
 * Date: 2019-11-27 11:01:56
 *
 * @author mufanglin
 *
 */
@Service("paycorepayPayengineGatewayOrderService")
public class PaycorepayPayengineGatewayOrderServiceImpl extends EntityServiceImpl<PaycorepayPayengineGatewayOrder, PaycorepayPayengineGatewayOrderDao> implements PaycorepayPayengineGatewayOrderService {

}
