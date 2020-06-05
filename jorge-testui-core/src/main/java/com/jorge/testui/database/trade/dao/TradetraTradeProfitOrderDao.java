/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraTradeProfitOrder;

/**
 * 交易分润列表 Mybatis Dao
 *
 * Date: 2019-11-27 10:58:35
 * @author mufanglin
 */
public interface TradetraTradeProfitOrderDao extends EntityMybatisDao<TradetraTradeProfitOrder> {
	
	@Delete("delete from tra_trade_profit_order where merch_order_no=#{merchOrderNo}")
	void deleteTradetraTradeProfitOrderByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
