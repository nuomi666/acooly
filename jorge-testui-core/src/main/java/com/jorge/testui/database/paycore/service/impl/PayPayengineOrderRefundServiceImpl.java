/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-19
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PayPayengineOrderRefundService;
import com.jorge.testui.database.paycore.dao.PayPayengineOrderRefundDao;
import com.jorge.testui.database.paycore.entity.PayPayengineOrderRefund;

/**
 * 退款信息表(主表) Service实现
 *
 * Date: 2019-12-19 17:40:43
 *
 * @author mufanglin
 *
 */
@Service("payPayengineOrderRefundService")
public class PayPayengineOrderRefundServiceImpl extends EntityServiceImpl<PayPayengineOrderRefund, PayPayengineOrderRefundDao> implements PayPayengineOrderRefundService {

}
