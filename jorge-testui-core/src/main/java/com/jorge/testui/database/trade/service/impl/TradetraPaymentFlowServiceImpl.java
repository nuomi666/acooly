/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraPaymentFlowService;
import com.jorge.testui.database.trade.dao.TradetraPaymentFlowDao;
import com.jorge.testui.database.trade.entity.TradetraPaymentFlow;

/**
 * 通用交易流程 Service实现
 *
 * Date: 2019-11-27 10:58:32
 *
 * @author mufanglin
 *
 */
@Service("tradetraPaymentFlowService")
public class TradetraPaymentFlowServiceImpl extends EntityServiceImpl<TradetraPaymentFlow, TradetraPaymentFlowDao> implements TradetraPaymentFlowService {

}
