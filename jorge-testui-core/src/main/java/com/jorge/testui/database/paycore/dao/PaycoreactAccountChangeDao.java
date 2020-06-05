/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccount;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountChange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户账户变动表 Mybatis Dao
 *
 * Date: 2019-11-27 11:01:54
 * @author mufanglin
 */
public interface PaycoreactAccountChangeDao extends EntityMybatisDao<PaycoreactAccountChange> {
 
 @Delete("delete from act_account_change where user_no = #{userNo}")
 void deletePaycoreactAccountChangeByUserNo(@Param("userNo") String userNo);
 
 @Select("select * from act_account_change where account_no=#{accountNo}")
 PaycoreactAccountChange selectPaycoreactAccountChangeByAccountNo(@Param("accountNo") String accountNo);
 
}
