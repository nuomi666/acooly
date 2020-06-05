/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraPaymentOrderService;
import com.jorge.testui.database.trade.dao.TradetraPaymentOrderDao;
import com.jorge.testui.database.trade.entity.TradetraPaymentOrder;

/**
 * 通用交易支付订单（请求流水记录） Service实现
 *
 * Date: 2019-11-27 10:58:33
 *
 * @author mufanglin
 *
 */
@Service("tradetraPaymentOrderService")
public class TradetraPaymentOrderServiceImpl extends EntityServiceImpl<TradetraPaymentOrder, TradetraPaymentOrderDao> implements TradetraPaymentOrderService {

}
