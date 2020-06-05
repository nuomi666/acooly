/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradebusiWhiteListService;
import com.jorge.testui.database.trade.dao.TradebusiWhiteListDao;
import com.jorge.testui.database.trade.entity.TradebusiWhiteList;

/**
 * 业务管控白名单 Service实现
 *
 * Date: 2019-11-27 10:58:31
 *
 * @author mufanglin
 *
 */
@Service("tradebusiWhiteListService")
public class TradebusiWhiteListServiceImpl extends EntityServiceImpl<TradebusiWhiteList, TradebusiWhiteListDao> implements TradebusiWhiteListService {

}
