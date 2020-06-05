/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycoreactAccountOperatorChangeService;
import com.jorge.testui.database.paycore.dao.PaycoreactAccountOperatorChangeDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountOperatorChange;

/**
 * 运营商表账户变动表 Service实现
 *
 * Date: 2019-11-27 11:01:55
 *
 * @author mufanglin
 *
 */
@Service("paycoreactAccountOperatorChangeService")
public class PaycoreactAccountOperatorChangeServiceImpl extends EntityServiceImpl<PaycoreactAccountOperatorChange, PaycoreactAccountOperatorChangeDao> implements PaycoreactAccountOperatorChangeService {

}
