/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycoreactAccountFreezeService;
import com.jorge.testui.database.paycore.dao.PaycoreactAccountFreezeDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountFreeze;

/**
 * 冻结账户表 Service实现
 *
 * Date: 2019-11-27 11:01:54
 *
 * @author mufanglin
 *
 */
@Service("paycoreactAccountFreezeService")
public class PaycoreactAccountFreezeServiceImpl extends EntityServiceImpl<PaycoreactAccountFreeze, PaycoreactAccountFreezeDao> implements PaycoreactAccountFreezeService {

}
