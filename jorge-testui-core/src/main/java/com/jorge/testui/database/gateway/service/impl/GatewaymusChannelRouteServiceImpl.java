/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.gateway.service.GatewaymusChannelRouteService;
import com.jorge.testui.database.gateway.dao.GatewaymusChannelRouteDao;
import com.jorge.testui.database.gateway.entity.GatewaymusChannelRoute;

/**
 * mus_channel_route Service实现
 *
 * Date: 2019-11-27 11:04:28
 *
 * @author mufanglin
 *
 */
@Service("gatewaymusChannelRouteService")
public class GatewaymusChannelRouteServiceImpl extends EntityServiceImpl<GatewaymusChannelRoute, GatewaymusChannelRouteDao> implements GatewaymusChannelRouteService {

}
