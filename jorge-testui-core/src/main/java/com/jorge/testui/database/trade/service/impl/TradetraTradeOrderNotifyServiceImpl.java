/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraTradeOrderNotifyService;
import com.jorge.testui.database.trade.dao.TradetraTradeOrderNotifyDao;
import com.jorge.testui.database.trade.entity.TradetraTradeOrderNotify;

/**
 * 交易系统异步通知 Service实现
 *
 * Date: 2019-11-27 10:58:34
 *
 * @author mufanglin
 *
 */
@Service("tradetraTradeOrderNotifyService")
public class TradetraTradeOrderNotifyServiceImpl extends EntityServiceImpl<TradetraTradeOrderNotify, TradetraTradeOrderNotifyDao> implements TradetraTradeOrderNotifyService {

}
