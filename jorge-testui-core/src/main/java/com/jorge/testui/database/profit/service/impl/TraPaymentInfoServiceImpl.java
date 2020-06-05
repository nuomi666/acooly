/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-19
 */
package com.jorge.testui.database.profit.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.profit.service.TraPaymentInfoService;
import com.jorge.testui.database.profit.dao.TraPaymentInfoDao;
import com.jorge.testui.database.profit.entity.TraPaymentInfo;

/**
 * 通用交易支付信息 Service实现
 *
 * Date: 2019-12-19 15:59:00
 *
 * @author mufanglin
 *
 */
@Service("traPaymentInfoService")
public class TraPaymentInfoServiceImpl extends EntityServiceImpl<TraPaymentInfo, TraPaymentInfoDao> implements TraPaymentInfoService {

}
