/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycoreactAccountBatOrderService;
import com.jorge.testui.database.paycore.dao.PaycoreactAccountBatOrderDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountBatOrder;

/**
 * 账务系统批量订单表 Service实现
 *
 * Date: 2019-11-27 11:01:53
 *
 * @author mufanglin
 *
 */
@Service("paycoreactAccountBatOrderService")
public class PaycoreactAccountBatOrderServiceImpl extends EntityServiceImpl<PaycoreactAccountBatOrder, PaycoreactAccountBatOrderDao> implements PaycoreactAccountBatOrderService {

}
