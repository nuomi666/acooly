/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-01-08
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.MusSignTransactionService;
import com.jorge.testui.database.gateway.dao.MusSignTransactionDao;
import com.jorge.testui.database.gateway.entity.MusSignTransaction;

/**
 * 签约流水 Service实现
 *
 * @author mufanglin
 * @date 2020-01-08 09:41:20
 */
@Service("musSignTransactionService")
public class MusSignTransactionServiceImpl extends EntityServiceImpl<MusSignTransaction, MusSignTransactionDao> implements MusSignTransactionService {

}
