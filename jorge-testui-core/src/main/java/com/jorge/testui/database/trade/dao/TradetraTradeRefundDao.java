/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraTradeRefund;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 交易退款 Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:35
 *
 * @author mufanglin
 */
public interface TradetraTradeRefundDao extends EntityMybatisDao<TradetraTradeRefund> {

    @Delete("delete from tra_trade_refund where orig_merch_order_no=#{origMerchOrderNo}")
    void deleteTradetraTradeRefundByOrigMerchOrderNo(@Param("origMerchOrderNo") String origMerchOrderNo);

    @Delete("delete from tra_trade_refund where refund_merch_order_no=#{refundMerchOrderNo}")
    void deleteTradetraTradeRefundByRefundMerchOrderNo(@Param("refundMerchOrderNo") String refundMerchOrderNo);

    @Select("select *  from tra_trade_refund where orig_merch_order_no=#{origMerchOrderNo}")
    List<TradetraTradeRefund> selectTradetraTradeRefundByOrigMerchOrderNo(@Param("origMerchOrderNo") String origMerchOrderNo);
}
