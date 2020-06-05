/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountFreeze;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 冻结账户表 Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:01:54
 *
 * @author mufanglin
 */
public interface PaycoreactAccountFreezeDao extends EntityMybatisDao<PaycoreactAccountFreeze> {

    @Delete("delete from act_account_freeze where account_no = #{accountNo}")
    void deletePaycoreactAccountFreezeOrderByAccountNo(@Param("accountNo") String accountNo);

    @Select("select * from act_account_freeze where account_no=#{accountNo}")
    PaycoreactAccountFreeze selectPaycoreactAccountFreezeByAccountNo(@Param("accountNo") String accountNo);

    @Select("select * from act_account_freeze where account_no=#{accountNo} order by id desc")
    List<PaycoreactAccountFreeze> selectPaycoreactAccountFreezeByAccountNoAll(@Param("accountNo") String accountNo);

}
