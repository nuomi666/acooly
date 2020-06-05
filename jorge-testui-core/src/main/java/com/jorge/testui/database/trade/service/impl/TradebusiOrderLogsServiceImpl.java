/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradebusiOrderLogsService;
import com.jorge.testui.database.trade.dao.TradebusiOrderLogsDao;
import com.jorge.testui.database.trade.entity.TradebusiOrderLogs;

/**
 * 业务管控订单信息 Service实现
 *
 * Date: 2019-11-27 10:58:31
 *
 * @author mufanglin
 *
 */
@Service("tradebusiOrderLogsService")
public class TradebusiOrderLogsServiceImpl extends EntityServiceImpl<TradebusiOrderLogs, TradebusiOrderLogsDao> implements TradebusiOrderLogsService {

}
