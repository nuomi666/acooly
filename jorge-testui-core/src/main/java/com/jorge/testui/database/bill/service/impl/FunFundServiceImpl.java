/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-02-19
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.FunFundService;
import com.jorge.testui.database.bill.dao.FunFundDao;
import com.jorge.testui.database.bill.entity.FunFund;

/**
 * 充值提现订单 Service实现
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
@Service("funFundService")
public class FunFundServiceImpl extends EntityServiceImpl<FunFund, FunFundDao> implements FunFundService {

}
