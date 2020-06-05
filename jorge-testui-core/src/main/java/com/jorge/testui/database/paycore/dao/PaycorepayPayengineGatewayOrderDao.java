/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineGatewayOrder;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 支付引擎网关订单表 Mybatis Dao
 *
 * Date: 2019-11-27 11:01:56
 * @author mufanglin
 */
public interface PaycorepayPayengineGatewayOrderDao extends EntityMybatisDao<PaycorepayPayengineGatewayOrder> {
 
 
 @Delete("delete from pay_payengine_gateway_order where gid=#{gid}")
 void deletePaycorepayPayengineGatewayOrderByGid(@Param("gid") String gid);
 
 @Select("select * from pay_payengine_gateway_order where gid=#{gid}")
 PaycorepayPayengineGatewayOrder selectPaycorepayPayengineGatewayOrderByGid(@Param("gid") String
                                                                                   gid);
 
}
