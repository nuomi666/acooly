/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycoreactAccountActionService;
import com.jorge.testui.database.paycore.dao.PaycoreactAccountActionDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountAction;

/**
 * 账户操作记录表 Service实现
 *
 * Date: 2019-11-27 11:01:53
 *
 * @author mufanglin
 *
 */
@Service("paycoreactAccountActionService")
public class PaycoreactAccountActionServiceImpl extends EntityServiceImpl<PaycoreactAccountAction, PaycoreactAccountActionDao> implements PaycoreactAccountActionService {

}
