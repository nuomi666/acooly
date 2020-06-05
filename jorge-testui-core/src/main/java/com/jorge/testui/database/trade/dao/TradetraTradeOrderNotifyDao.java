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
import com.jorge.testui.database.trade.entity.TradetraTradeOrderNotify;

/**
 * 交易系统异步通知 Mybatis Dao
 *
 * Date: 2019-11-27 10:58:34
 * @author mufanglin
 */
public interface TradetraTradeOrderNotifyDao extends EntityMybatisDao<TradetraTradeOrderNotify> {
	
	@Delete("delete from tra_trade_order_notify where merch_order_no=#{merchOrderNo}")
	void deleteTradetraTradeOrderNotifyByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
