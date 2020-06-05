/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycorepayPayengineOrderService;
import com.jorge.testui.database.paycore.dao.PaycorepayPayengineOrderDao;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineOrder;

/**
 * 支付引擎订单表 Service实现
 *
 * Date: 2019-11-27 11:01:56
 *
 * @author mufanglin
 *
 */
@Service("paycorepayPayengineOrderService")
public class PaycorepayPayengineOrderServiceImpl extends EntityServiceImpl<PaycorepayPayengineOrder, PaycorepayPayengineOrderDao> implements PaycorepayPayengineOrderService {

}
