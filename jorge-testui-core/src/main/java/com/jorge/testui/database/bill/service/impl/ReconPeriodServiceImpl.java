/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-05
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.ReconPeriodService;
import com.jorge.testui.database.bill.dao.ReconPeriodDao;
import com.jorge.testui.database.bill.entity.ReconPeriod;

/**
 * 每日对账结果 Service实现
 *
 * Date: 2019-12-05 09:52:01
 *
 * @author mufanglin
 *
 */
@Service("reconPeriodService")
public class ReconPeriodServiceImpl extends EntityServiceImpl<ReconPeriod, ReconPeriodDao> implements ReconPeriodService {

}
