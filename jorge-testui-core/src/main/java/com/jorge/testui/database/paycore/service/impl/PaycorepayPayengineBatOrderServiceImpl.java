/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycorepayPayengineBatOrderService;
import com.jorge.testui.database.paycore.dao.PaycorepayPayengineBatOrderDao;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineBatOrder;

/**
 * 支付引擎批量订单表 Service实现
 *
 * Date: 2019-11-27 11:01:55
 *
 * @author mufanglin
 *
 */
@Service("paycorepayPayengineBatOrderService")
public class PaycorepayPayengineBatOrderServiceImpl extends EntityServiceImpl<PaycorepayPayengineBatOrder, PaycorepayPayengineBatOrderDao> implements PaycorepayPayengineBatOrderService {

}
