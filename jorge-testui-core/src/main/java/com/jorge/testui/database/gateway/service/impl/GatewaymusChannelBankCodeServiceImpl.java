/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusChannelBankCodeService;
import com.jorge.testui.database.gateway.dao.GatewaymusChannelBankCodeDao;
import com.jorge.testui.database.gateway.entity.GatewaymusChannelBankCode;

/**
 * 渠道银行编码对应表 Service实现
 *
 * Date: 2019-11-27 11:04:28
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusChannelBankCodeService")
public class GatewaymusChannelBankCodeServiceImpl extends EntityServiceImpl<GatewaymusChannelBankCode, GatewaymusChannelBankCodeDao> implements GatewaymusChannelBankCodeService {

}
