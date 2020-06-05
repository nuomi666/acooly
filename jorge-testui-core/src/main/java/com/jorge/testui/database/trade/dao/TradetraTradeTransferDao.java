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
import com.jorge.testui.database.trade.entity.TradetraTradeTransfer;

/**
 * 交易转账记录 Mybatis Dao
 *
 * Date: 2019-11-27 10:58:35
 * @author mufanglin
 */
public interface TradetraTradeTransferDao extends EntityMybatisDao<TradetraTradeTransfer> {
	
	@Delete("delete from tra_trade_transfer where merch_order_no=#{merchOrderNo}")
	void deleteTradetraTradeTransferByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
	
	@Select("select *  from tra_trade_transfer where merch_order_no=#{merchOrderNo}")
	List<TradetraTradeTransfer> selectTradetraTradeTransferByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
