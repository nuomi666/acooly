/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradefunFund;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 充值提现订单 Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:32
 *
 * @author mufanglin
 */
public interface TradefunFundDao extends EntityMybatisDao<TradefunFund> {
    @Delete("delete from fun_fund where merch_order_no=#{merchOrderNo}")
    void deleteTradefunFundByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Select("select *  from fun_fund where merch_order_no=#{merchOrderNo}")
    TradefunFund selectTradefunFundByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

}
