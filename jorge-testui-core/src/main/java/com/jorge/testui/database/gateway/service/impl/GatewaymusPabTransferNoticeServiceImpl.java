/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusPabTransferNoticeService;
import com.jorge.testui.database.gateway.dao.GatewaymusPabTransferNoticeDao;
import com.jorge.testui.database.gateway.entity.GatewaymusPabTransferNotice;

/**
 * mus_pab_transfer_notice Service实现
 *
 * Date: 2019-11-27 11:04:30
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusPabTransferNoticeService")
public class GatewaymusPabTransferNoticeServiceImpl extends EntityServiceImpl<GatewaymusPabTransferNotice, GatewaymusPabTransferNoticeDao> implements GatewaymusPabTransferNoticeService {

}
