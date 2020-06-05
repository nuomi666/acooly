/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraPaymentFlow;
import com.jorge.testui.database.trade.entity.TradetraPaymentOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * 通用交易支付订单（请求流水记录） Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:33
 *
 * @author mufanglin
 */
public interface TradetraPaymentOrderDao extends EntityMybatisDao<TradetraPaymentOrder> {

    @Delete("delete from tra_payment_order where merch_order_no=#{merchOrderNo}")
    void deleteTradetraPaymentOrderByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Delete("delete from tra_payment_order where partner_id=#{partnerId}")
    void deleteTradetraPaymentOrderByPartnerId(@Param("partnerId") String partnerId);

    @Select("select *  from tra_payment_order where merch_order_no=#{merchOrderNo}")
    List<TradetraPaymentFlow> selectTradetraPaymentOrderByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Update("update tra_payment_order set update_time=#{updateTime} where merch_order_no=#{merchOrderNo}")
    void updateTradetraPaymentOrderByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo,
                                                  @Param("updateTime") Date updateTime);
}
