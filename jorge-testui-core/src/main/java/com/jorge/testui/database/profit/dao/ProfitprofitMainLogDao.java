/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitprofitMainLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * profit_main_log Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:05:03
 *
 * @author mufanglin
 */
public interface ProfitprofitMainLogDao extends EntityMybatisDao<ProfitprofitMainLog> {

    @Delete("delete from profit_main_log where merch_order_no=#{merchOrderNo}")
    void deleteProfitprofitMainLogByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Select("select * from profit_main_log where merch_order_no=#{merchOrderNo}")
    ProfitprofitMainLog selectProfitprofitMainLogByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
