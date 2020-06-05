/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-05
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.ReconReconResultService;
import com.jorge.testui.database.bill.dao.ReconReconResultDao;
import com.jorge.testui.database.bill.entity.ReconReconResult;

/**
 * 对账结果记录表 Service实现
 *
 * Date: 2019-12-05 09:52:02
 *
 * @author mufanglin
 *
 */
@Service("reconReconResultService")
public class ReconReconResultServiceImpl extends EntityServiceImpl<ReconReconResult, ReconReconResultDao> implements ReconReconResultService {

}
