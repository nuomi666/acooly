/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraPaymentService;
import com.jorge.testui.database.trade.dao.TradetraPaymentDao;
import com.jorge.testui.database.trade.entity.TradetraPayment;

/**
 * 通用交易支付 Service实现
 *
 * Date: 2019-11-27 10:58:32
 *
 * @author mufanglin
 *
 */
@Service("tradetraPaymentService")
public class TradetraPaymentServiceImpl extends EntityServiceImpl<TradetraPayment, TradetraPaymentDao> implements TradetraPaymentService {

}
