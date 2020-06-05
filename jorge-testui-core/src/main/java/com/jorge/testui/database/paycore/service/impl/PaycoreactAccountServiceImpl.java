/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.paycore.service.PaycoreactAccountService;
import com.jorge.testui.database.paycore.dao.PaycoreactAccountDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccount;

/**
 * 用户账户 Service实现
 *
 * Date: 2019-11-27 11:01:53
 *
 * @author mufanglin
 *
 */
@Service("paycoreactAccountService")
public class PaycoreactAccountServiceImpl extends EntityServiceImpl<PaycoreactAccount, PaycoreactAccountDao> implements PaycoreactAccountService {

}
