/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-17
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitTransRefundLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * profit_trans_refund_log Mybatis Dao
 * <p>
 * Date: 2019-12-17 17:40:37
 *
 * @author mufanglin
 */
public interface ProfitTransRefundLogDao extends EntityMybatisDao<ProfitTransRefundLog> {

    @Delete("delete from profit_trans_refund_log where out_biz_no=#{outBizNo}")
    void deleteProfitTransRefundLogByOutBizNo(@Param("outBizNo") String outBizNo);

    @Select("select * from profit_trans_refund_log where out_biz_no=#{outBizNo}")
    ProfitTransRefundLog selectProfitTransRefundLogByOutBizNo(@Param("outBizNo") String outBizNo);
}
