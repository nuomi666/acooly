/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraPayment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 通用交易支付 Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:32
 *
 * @author mufanglin
 */
public interface TradetraPaymentDao extends EntityMybatisDao<TradetraPayment> {

    @Delete("delete from tra_payment where merch_order_no=#{merchOrderNo}")
    void deleteTradetraPaymentByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Delete("delete from tra_payment where partner_id=#{partnerId}")
    void deleteTradetraPaymentByPartnerId(@Param("partnerId") String partnerId);

    @Select("select *  from tra_payment where merch_order_no=#{merchOrderNo}")
    TradetraPayment selectTradetraPaymentByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
