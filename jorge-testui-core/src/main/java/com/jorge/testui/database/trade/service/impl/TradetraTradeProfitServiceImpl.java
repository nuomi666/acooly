/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraTradeProfitService;
import com.jorge.testui.database.trade.dao.TradetraTradeProfitDao;
import com.jorge.testui.database.trade.entity.TradetraTradeProfit;

/**
 * 交易分润列表 Service实现
 *
 * Date: 2019-11-27 10:58:34
 *
 * @author mufanglin
 *
 */
@Service("tradetraTradeProfitService")
public class TradetraTradeProfitServiceImpl extends EntityServiceImpl<TradetraTradeProfit, TradetraTradeProfitDao> implements TradetraTradeProfitService {

}
