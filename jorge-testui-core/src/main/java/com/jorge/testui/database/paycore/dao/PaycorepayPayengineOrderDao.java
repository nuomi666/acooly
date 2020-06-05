/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountChange;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 支付引擎订单表 Mybatis Dao
 *
 * Date: 2019-11-27 11:01:56
 * @author mufanglin
 */
public interface PaycorepayPayengineOrderDao extends EntityMybatisDao<PaycorepayPayengineOrder> {
 
 @Delete("delete from pay_payengine_order where gid=#{gid}")
 void deletePaycorepayPayengineOrderByGid(@Param("gid") String gid);
 
 @Delete("delete from pay_payengine_order where user_no=#{userNo}")
 void deletePaycorepayPayengineOrderByNserNo(@Param("userNo") String userNo);
 
 @Select("select * from pay_payengine_order where gid=#{gid}")
 PaycorepayPayengineOrder selectPaycorepayPayengineOrderByGid(@Param("gid") String gid);
 
}
