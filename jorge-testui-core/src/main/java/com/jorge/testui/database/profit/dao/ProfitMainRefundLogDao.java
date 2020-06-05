/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-17
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitMainRefundLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * profit_main_refund_log Mybatis Dao
 * <p>
 * Date: 2019-12-17 16:50:59
 *
 * @author mufanglin
 */
public interface ProfitMainRefundLogDao extends EntityMybatisDao<ProfitMainRefundLog> {

    @Delete("delete from profit_main_refund_log where out_biz_no=#{outBizNo}")
    void deleteProfitMainRefundLogByOutBizNo(@Param("outBizNo") String outBizNo);

    @Select("select * from profit_main_refund_log where original_out_biz_no=#{originalOutBizNo}")
    ProfitMainRefundLog selectProfitMainRefundLogByOriginalOutBizNo(@Param("originalOutBizNo") String originalOutBizNo);
}
