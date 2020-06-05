/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.GatewaymusBankKeyManage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 银行密钥管理 Mybatis Dao
 *
 * Date: 2019-11-27 11:04:27
 * @author mufanglin
 */
public interface GatewaymusBankKeyManageDao extends EntityMybatisDao<GatewaymusBankKeyManage> {
 
 @Update("UPDATE mus_bank_key_manage SET posting_flag = #{postingFlag} where id=#{id}")
 void updateGatewaymusBankKeyManageById(@Param("id") String id,
                                        @Param("postingFlag") String postingFlag );
 
}
