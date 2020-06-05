/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitprofitTransLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * profit_trans_log Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:05:04
 *
 * @author mufanglin
 */
public interface ProfitprofitTransLogDao extends EntityMybatisDao<ProfitprofitTransLog> {

    @Delete("delete from profit_trans_log")
    void deleteProfitprofitTransLogAll();

    @Select("select * from profit_trans_log where profit_no=#{profitNo}")
    ProfitprofitTransLog selectProfitprofitTransLogByProfitNo(@Param("profitNo") String profitNo);

}
