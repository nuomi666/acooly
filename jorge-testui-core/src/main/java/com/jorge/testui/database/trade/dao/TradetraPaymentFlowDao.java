/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraPaymentFlow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * 通用交易流程 Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:32
 *
 * @author mufanglin
 */
public interface TradetraPaymentFlowDao extends EntityMybatisDao<TradetraPaymentFlow> {

    @Delete("delete from tra_payment_flow where merch_order_no=#{merchOrderNo}")
    void deleteTradetraPaymentFlowByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Delete("delete from tra_payment_flow where partner_id=#{partnerId}")
    void deleteTradetraPaymentFlowByPartnerId(@Param("partnerId") String partnerId);

    @Select("select * from tra_payment_flow where merch_order_no=#{merchOrderNo}")
    List<TradetraPaymentFlow> selectTradetraPaymentFlowByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Select("select * from tra_payment_flow where biz_order_no=#{bizOrderNo}")
    TradetraPaymentFlow selectTradetraPaymentFlowByBizOrderNo(@Param("bizOrderNo") String bizOrderNo);

    @Update("update tra_payment_flow set create_time=#{createTime} where merch_order_no=#{merchOrderNo}")
    void updateTradetraPaymentFlowByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo,
                                                 @Param("createTime") Date createTime);

    @Select("select * from tra_payment_flow where merch_order_no=#{merchOrderNo} and flow_node=#{flowNode}")
    TradetraPaymentFlow selectTradetraPaymentFlowByMerchOrderNoAndFlowNode(@Param("merchOrderNo") String merchOrderNo,@Param("flowNode")String flowNode);


}
