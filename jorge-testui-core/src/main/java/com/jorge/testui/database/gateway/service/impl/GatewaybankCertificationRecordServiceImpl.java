/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaybankCertificationRecordService;
import com.jorge.testui.database.gateway.dao.GatewaybankCertificationRecordDao;
import com.jorge.testui.database.gateway.entity.GatewaybankCertificationRecord;

/**
 * 银行卡四要素记录表 Service实现
 *
 * Date: 2019-11-27 11:04:25
 *
 * @author mufanglin
 *
 */
@Service("gatewaybankCertificationRecordService")
public class GatewaybankCertificationRecordServiceImpl extends EntityServiceImpl<GatewaybankCertificationRecord, GatewaybankCertificationRecordDao> implements GatewaybankCertificationRecordService {

}
