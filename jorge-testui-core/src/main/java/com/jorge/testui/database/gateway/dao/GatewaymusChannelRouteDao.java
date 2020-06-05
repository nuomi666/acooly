/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.GatewaymusChannelRoute;
import com.jorge.testui.database.paycore.entity.PaycoreactAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * mus_channel_route Mybatis Dao
 *
 * Date: 2019-11-27 11:04:28
 * @author mufanglin
 */
public interface GatewaymusChannelRouteDao extends EntityMybatisDao<GatewaymusChannelRoute> {
 
 @Select("select * from mus_channel_route where inst_channel_api=#{instChannelApi} and " +
         "route_type=#{routeType}")
 GatewaymusChannelRoute selectGatewaymusChannelRouteByApiAndRoType(
               @Param("instChannelApi") String instChannelApi,@Param("routeType") String routeType);
 
}
