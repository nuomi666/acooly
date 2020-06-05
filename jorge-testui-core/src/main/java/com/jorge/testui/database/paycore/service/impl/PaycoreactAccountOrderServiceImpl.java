/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycoreactAccountOrderService;
import com.jorge.testui.database.paycore.dao.PaycoreactAccountOrderDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountOrder;

/**
 * 账务系统订单表 Service实现
 *
 * Date: 2019-11-27 11:01:55
 *
 * @author mufanglin
 *
 */
@Service("paycoreactAccountOrderService")
public class PaycoreactAccountOrderServiceImpl extends EntityServiceImpl<PaycoreactAccountOrder, PaycoreactAccountOrderDao> implements PaycoreactAccountOrderService {

}
