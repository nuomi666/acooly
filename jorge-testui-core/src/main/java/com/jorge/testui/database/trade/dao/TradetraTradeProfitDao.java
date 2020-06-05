/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraTradeProfit;

/**
 * 交易分润列表 Mybatis Dao
 *
 * Date: 2019-11-27 10:58:34
 * @author mufanglin
 */
public interface TradetraTradeProfitDao extends EntityMybatisDao<TradetraTradeProfit> {
	
	@Delete("delete from tra_trade_profit where merch_order_no=#{merchOrderNo}")
	void deleteTradetraTradeProfitByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
	
	@Select("select *  from tra_trade_profit where merch_order_no=#{merchOrderNo}")
	List<TradetraTradeProfit> selectTradetraTradeProfitByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
