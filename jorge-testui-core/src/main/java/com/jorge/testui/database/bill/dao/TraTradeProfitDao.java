/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-02-19
 */
 package com.jorge.testui.database.bill.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.bill.entity.TraTradeProfit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 交易分润列表 Mybatis Dao
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
public interface TraTradeProfitDao extends EntityMybatisDao<TraTradeProfit> {
     @Delete("delete from tra_trade_profit where merch_order_no=#{merchOrderNo}")
     void deleteTraTradeProfitByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

     @Select("select * from tra_trade_profit where merch_order_no = #{merchOrderNo}")
     TraTradeProfit selectTraTradeProfitByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
    
    @Delete("delete from tra_trade_profit where gid=#{gid}")
    void deleteTraTradeProfitByGid(@Param("gid") String gid);
    
    @Delete("delete from tra_trade_profit where period_no=#{periodNo}")
    void deleteTraTradeProfitByPeriodNo(@Param("periodNo") String periodNo);
    
}
