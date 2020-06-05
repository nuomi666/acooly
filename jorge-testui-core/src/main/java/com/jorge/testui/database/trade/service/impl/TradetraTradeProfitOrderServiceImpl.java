/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraTradeProfitOrderService;
import com.jorge.testui.database.trade.dao.TradetraTradeProfitOrderDao;
import com.jorge.testui.database.trade.entity.TradetraTradeProfitOrder;

/**
 * 交易分润列表 Service实现
 *
 * Date: 2019-11-27 10:58:35
 *
 * @author mufanglin
 *
 */
@Service("tradetraTradeProfitOrderService")
public class TradetraTradeProfitOrderServiceImpl extends EntityServiceImpl<TradetraTradeProfitOrder, TradetraTradeProfitOrderDao> implements TradetraTradeProfitOrderService {

}
