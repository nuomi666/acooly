/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-19
 */
 package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PayPayengineOrderRefund;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * 退款信息表(主表) Mybatis Dao
 *
 * Date: 2019-12-19 17:40:43
 * @author mufanglin
 */
public interface PayPayengineOrderRefundDao extends EntityMybatisDao<PayPayengineOrderRefund> {
 
 @Delete("delete from pay_payengine_order_refund where gid=#{gid}")
 void deletePayPayengineOrderRefundByGid(@Param("gid") String gid);

}
