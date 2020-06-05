/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusBankCardBinService;
import com.jorge.testui.database.gateway.dao.GatewaymusBankCardBinDao;
import com.jorge.testui.database.gateway.entity.GatewaymusBankCardBin;

/**
 * mus_bank_card_bin Service实现
 *
 * Date: 2019-11-27 11:04:26
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusBankCardBinService")
public class GatewaymusBankCardBinServiceImpl extends EntityServiceImpl<GatewaymusBankCardBin, GatewaymusBankCardBinDao> implements GatewaymusBankCardBinService {

}
