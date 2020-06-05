/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaycertCertificationRecordService;
import com.jorge.testui.database.gateway.dao.GatewaycertCertificationRecordDao;
import com.jorge.testui.database.gateway.entity.GatewaycertCertificationRecord;

/**
 * 实名认证记录表 Service实现
 *
 * Date: 2019-11-27 11:04:26
 *
 * @author mufanglin
 *
 */
@Service("gatewaycertCertificationRecordService")
public class GatewaycertCertificationRecordServiceImpl extends EntityServiceImpl<GatewaycertCertificationRecord, GatewaycertCertificationRecordDao> implements GatewaycertCertificationRecordService {

}
