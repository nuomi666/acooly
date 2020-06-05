/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradetraPaymentInfoService;
import com.jorge.testui.database.trade.dao.TradetraPaymentInfoDao;
import com.jorge.testui.database.trade.entity.TradetraPaymentInfo;

/**
 * 通用交易支付信息 Service实现
 *
 * Date: 2019-11-27 10:58:33
 *
 * @author mufanglin
 *
 */
@Service("tradetraPaymentInfoService")
public class TradetraPaymentInfoServiceImpl extends EntityServiceImpl<TradetraPaymentInfo, TradetraPaymentInfoDao> implements TradetraPaymentInfoService {

}
