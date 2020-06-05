/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineGatewayOrder;
import com.jorge.testui.database.paycore.entity.PaycorepayPayengineOrderExtend;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 支付引擎订单扩展表 Mybatis Dao
 *
 * Date: 2019-11-27 11:01:56
 * @author mufanglin
 */
public interface PaycorepayPayengineOrderExtendDao extends EntityMybatisDao<PaycorepayPayengineOrderExtend> {
 
 @Delete("delete from pay_payengine_order_extend where gid=#{gid}")
 void deletePaycorepayPayengineOrderExtendByGid(@Param("gid") String gid);
 
 @Select("select * from pay_payengine_order_extend where gid=#{gid}")
 PaycorepayPayengineOrderExtend selectPaycorepayPayengineOrderExtendByGid(@Param("gid") String
                                                                                    gid);
 
}
