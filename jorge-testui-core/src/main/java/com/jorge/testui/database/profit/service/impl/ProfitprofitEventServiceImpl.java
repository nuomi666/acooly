/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.profit.service.ProfitprofitEventService;
import com.jorge.testui.database.profit.dao.ProfitprofitEventDao;
import com.jorge.testui.database.profit.entity.ProfitprofitEvent;

/**
 * profit_event Service实现
 *
 * Date: 2019-11-27 11:05:03
 *
 * @author mufanglin
 *
 */
@Service("profitprofitEventService")
public class ProfitprofitEventServiceImpl extends EntityServiceImpl<ProfitprofitEvent, ProfitprofitEventDao> implements ProfitprofitEventService {

}
