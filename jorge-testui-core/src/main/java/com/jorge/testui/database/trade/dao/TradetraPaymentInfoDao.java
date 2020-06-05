/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraPaymentFlow;
import com.jorge.testui.database.trade.entity.TradetraPaymentInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 通用交易支付信息 Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:33
 *
 * @author mufanglin
 */
public interface TradetraPaymentInfoDao extends EntityMybatisDao<TradetraPaymentInfo> {

    @Delete("delete from tra_payment_info where merch_order_no=#{merchOrderNo}")
    void deleteTradetraPaymentInfoByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Delete("delete from tra_payment_info")
    void deleteTradetraPaymentInfoByAll();

    @Select("select *  from tra_payment_info where merch_order_no=#{merchOrderNo}")
    List<TradetraPaymentFlow> selectTradetraPaymentInfoByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
