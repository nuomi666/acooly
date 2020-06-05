/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraTradeTransferService;
import com.jorge.testui.database.trade.dao.TradetraTradeTransferDao;
import com.jorge.testui.database.trade.entity.TradetraTradeTransfer;

/**
 * 交易转账记录 Service实现
 *
 * Date: 2019-11-27 10:58:35
 *
 * @author mufanglin
 *
 */
@Service("tradetraTradeTransferService")
public class TradetraTradeTransferServiceImpl extends EntityServiceImpl<TradetraTradeTransfer, TradetraTradeTransferDao> implements TradetraTradeTransferService {

}
