/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraTradeExtGoods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 交易商品信息 Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:34
 *
 * @author mufanglin
 */
public interface TradetraTradeExtGoodsDao extends EntityMybatisDao<TradetraTradeExtGoods> {

    @Delete("delete from tra_trade_ext_goods where merch_order_no=#{merchOrderNo}")
    void deleteTradetraTradeExtGoodsByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Select("select *  from tra_trade_ext_goods where merch_order_no=#{merchOrderNo}")
    List<TradetraTradeExtGoods> selectTradetraTradeExtGoodsByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

}
