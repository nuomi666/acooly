/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-02-19
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.TraTradeService;
import com.jorge.testui.database.bill.dao.TraTradeDao;
import com.jorge.testui.database.bill.entity.TraTrade;

/**
 * 交易订单记录 Service实现
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
@Service("traTradeService")
public class TraTradeServiceImpl extends EntityServiceImpl<TraTrade, TraTradeDao> implements TraTradeService {

}
