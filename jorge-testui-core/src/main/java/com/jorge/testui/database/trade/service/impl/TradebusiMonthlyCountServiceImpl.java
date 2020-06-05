/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradebusiMonthlyCountService;
import com.jorge.testui.database.trade.dao.TradebusiMonthlyCountDao;
import com.jorge.testui.database.trade.entity.TradebusiMonthlyCount;

/**
 * 月统计数据 Service实现
 *
 * Date: 2019-11-27 10:58:30
 *
 * @author mufanglin
 *
 */
@Service("tradebusiMonthlyCountService")
public class TradebusiMonthlyCountServiceImpl extends EntityServiceImpl<TradebusiMonthlyCount, TradebusiMonthlyCountDao> implements TradebusiMonthlyCountService {

}
