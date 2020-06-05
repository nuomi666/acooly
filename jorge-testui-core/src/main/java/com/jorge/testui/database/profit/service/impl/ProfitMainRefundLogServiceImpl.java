/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-17
 */
package com.jorge.testui.database.profit.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.profit.service.ProfitMainRefundLogService;
import com.jorge.testui.database.profit.dao.ProfitMainRefundLogDao;
import com.jorge.testui.database.profit.entity.ProfitMainRefundLog;

/**
 * profit_main_refund_log Service实现
 *
 * Date: 2019-12-17 16:50:59
 *
 * @author mufanglin
 *
 */
@Service("profitMainRefundLogService")
public class ProfitMainRefundLogServiceImpl extends EntityServiceImpl<ProfitMainRefundLog, ProfitMainRefundLogDao> implements ProfitMainRefundLogService {

}
