/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-05
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.ReconChannelRecordService;
import com.jorge.testui.database.bill.dao.ReconChannelRecordDao;
import com.jorge.testui.database.bill.entity.ReconChannelRecord;

/**
 * 渠道记录表 Service实现
 *
 * Date: 2019-12-05 09:52:01
 *
 * @author mufanglin
 *
 */
@Service("reconChannelRecordService")
public class ReconChannelRecordServiceImpl extends EntityServiceImpl<ReconChannelRecord, ReconChannelRecordDao> implements ReconChannelRecordService {

}
