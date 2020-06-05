/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountOperatorChange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * 运营商表账户变动表 Mybatis Dao
 *
 * Date: 2019-11-27 11:01:55
 * @author mufanglin
 */
public interface PaycoreactAccountOperatorChangeDao extends EntityMybatisDao<PaycoreactAccountOperatorChange> {
 
 @Delete("delete from act_account_operator_change where gid = #{gid}")
 void deletePaycoreactAccountOperatorChangeByGid(@Param("gid") String gid);
 
}
