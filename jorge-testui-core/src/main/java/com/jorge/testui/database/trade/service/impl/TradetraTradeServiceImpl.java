/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraTradeService;
import com.jorge.testui.database.trade.dao.TradetraTradeDao;
import com.jorge.testui.database.trade.entity.TradetraTrade;

/**
 * 交易订单记录 Service实现
 *
 * Date: 2019-11-27 10:58:33
 *
 * @author mufanglin
 *
 */
@Service("tradetraTradeService")
public class TradetraTradeServiceImpl extends EntityServiceImpl<TradetraTrade, TradetraTradeDao> implements TradetraTradeService {

}
