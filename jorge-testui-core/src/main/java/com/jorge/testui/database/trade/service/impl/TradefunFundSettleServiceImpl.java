/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradefunFundSettleService;
import com.jorge.testui.database.trade.dao.TradefunFundSettleDao;
import com.jorge.testui.database.trade.entity.TradefunFundSettle;

/**
 * 资金结算管理 Service实现
 *
 * Date: 2019-11-27 10:58:32
 *
 * @author mufanglin
 *
 */
@Service("tradefunFundSettleService")
public class TradefunFundSettleServiceImpl extends EntityServiceImpl<TradefunFundSettle, TradefunFundSettleDao> implements TradefunFundSettleService {

}
