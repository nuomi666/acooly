/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-01-08
 */
 package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.MusSignTransaction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 签约流水 Mybatis Dao
 *
 * @author mufanglin
 * @date 2020-01-08 09:41:20
 */
public interface MusSignTransactionDao extends EntityMybatisDao<MusSignTransaction> {

    @Select("select * from mus_sign_transaction where merch_order_no =#{merchOrderNo}")
    MusSignTransaction findSignTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Delete("delete from mus_sign_transaction where merch_order_no =#{merchOrderNo}")
    void deleteSignTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
