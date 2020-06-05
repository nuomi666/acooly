/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-02-19
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.TraTradeProfitService;
import com.jorge.testui.database.bill.dao.TraTradeProfitDao;
import com.jorge.testui.database.bill.entity.TraTradeProfit;

/**
 * 交易分润列表 Service实现
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
@Service("traTradeProfitService")
public class TraTradeProfitServiceImpl extends EntityServiceImpl<TraTradeProfit, TraTradeProfitDao> implements TraTradeProfitService {

}
