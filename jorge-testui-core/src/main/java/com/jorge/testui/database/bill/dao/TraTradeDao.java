/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-02-19
 */
 package com.jorge.testui.database.bill.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.bill.entity.TraTrade;
import com.jorge.testui.database.trade.entity.TradetraTrade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 交易订单记录 Mybatis Dao
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
public interface TraTradeDao extends EntityMybatisDao<TraTrade> {
     @Delete("delete from tra_trade where merch_order_no=#{merchOrderNo}")
     void deleteTraTradeByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

     @Select("select * from tra_trade where merch_order_no = #{merchOrderNo}")
     TraTrade selectTraTradeByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
    
    @Delete("delete from tra_trade where period_no=#{periodNo}")
    void deleteTraTradeByPeriodNo(@Param("periodNo") String periodNo);
    
}
