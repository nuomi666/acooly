/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.profit.service.ProfitprofitTransLogService;
import com.jorge.testui.database.profit.dao.ProfitprofitTransLogDao;
import com.jorge.testui.database.profit.entity.ProfitprofitTransLog;

/**
 * profit_trans_log Service实现
 *
 * Date: 2019-11-27 11:05:04
 *
 * @author mufanglin
 *
 */
@Service("profitprofitTransLogService")
public class ProfitprofitTransLogServiceImpl extends EntityServiceImpl<ProfitprofitTransLog, ProfitprofitTransLogDao> implements ProfitprofitTransLogService {

}
