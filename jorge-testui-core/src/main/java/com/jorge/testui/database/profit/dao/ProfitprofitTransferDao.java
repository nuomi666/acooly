/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitprofitTransfer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * profit_transfer Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:05:04
 *
 * @author mufanglin
 */
public interface ProfitprofitTransferDao extends EntityMybatisDao<ProfitprofitTransfer> {

    @Delete("delete from profit_transfer where profit_no=#{profitNo}")
    void deleteProfitprofitTransferByProfitNo(@Param("profitNo") String profitNo);
}
