/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradebusiDailyCountService;
import com.jorge.testui.database.trade.dao.TradebusiDailyCountDao;
import com.jorge.testui.database.trade.entity.TradebusiDailyCount;

/**
 * 日统计数据 Service实现
 *
 * Date: 2019-11-27 10:58:30
 *
 * @author mufanglin
 *
 */
@Service("tradebusiDailyCountService")
public class TradebusiDailyCountServiceImpl extends EntityServiceImpl<TradebusiDailyCount, TradebusiDailyCountDao> implements TradebusiDailyCountService {

}
