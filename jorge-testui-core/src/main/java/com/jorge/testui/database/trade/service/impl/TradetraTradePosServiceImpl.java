/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraTradePosService;
import com.jorge.testui.database.trade.dao.TradetraTradePosDao;
import com.jorge.testui.database.trade.entity.TradetraTradePos;

/**
 * pos交易订单数据 Service实现
 *
 * Date: 2019-11-27 10:58:34
 *
 * @author mufanglin
 *
 */
@Service("tradetraTradePosService")
public class TradetraTradePosServiceImpl extends EntityServiceImpl<TradetraTradePos, TradetraTradePosDao> implements TradetraTradePosService {

}
