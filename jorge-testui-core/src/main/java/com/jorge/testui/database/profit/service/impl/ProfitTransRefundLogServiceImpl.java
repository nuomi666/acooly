/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-17
 */
package com.jorge.testui.database.profit.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.profit.service.ProfitTransRefundLogService;
import com.jorge.testui.database.profit.dao.ProfitTransRefundLogDao;
import com.jorge.testui.database.profit.entity.ProfitTransRefundLog;

/**
 * profit_trans_refund_log Service实现
 *
 * Date: 2019-12-17 17:40:37
 *
 * @author mufanglin
 *
 */
@Service("profitTransRefundLogService")
public class ProfitTransRefundLogServiceImpl extends EntityServiceImpl<ProfitTransRefundLog, ProfitTransRefundLogDao> implements ProfitTransRefundLogService {

}
