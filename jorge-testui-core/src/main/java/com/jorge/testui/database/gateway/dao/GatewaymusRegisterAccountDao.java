/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.GatewaymusRegisterAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 注册开户 Mybatis Dao
 *
 * Date: 2019-11-27 11:04:30
 * @author mufanglin
 */
public interface GatewaymusRegisterAccountDao extends EntityMybatisDao<GatewaymusRegisterAccount> {
 @Select("SELECT * FROM mus_register_account WHERE user_no = #{userNo} and open_account_use = #{OpenAccountUse}")
 GatewaymusRegisterAccount selectMusRegisterAccountByUserNoAndOpenAccountUse(@Param("userNo") String userNo,@Param(
         "OpenAccountUse") String OpenAccountUse);

 @Select("SELECT * FROM mus_register_account WHERE account_no = #{accountNo}")
 GatewaymusRegisterAccount selectMusRegisterAccountByAccountNo(@Param("accountNo") String accountNo);
}
