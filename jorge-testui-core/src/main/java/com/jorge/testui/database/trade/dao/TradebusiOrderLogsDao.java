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
import com.jorge.testui.database.trade.entity.TradebusiOrderLogs;

/**
 * 业务管控订单信息 Mybatis Dao
 *
 * Date: 2019-11-27 10:58:31
 * @author mufanglin
 */
public interface TradebusiOrderLogsDao extends EntityMybatisDao<TradebusiOrderLogs> {
	
	@Delete("delete from busi_order_logs where trade_type=#{tradeType}")
	void deleteTradebusiOrderLogsByTradeType(@Param("tradeType") String tradeType);
}
