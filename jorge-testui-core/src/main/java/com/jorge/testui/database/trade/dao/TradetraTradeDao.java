/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.trade.entity.TradetraTrade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 交易订单记录 Mybatis Dao
 * <p>
 * Date: 2019-11-27 10:58:33
 *
 * @author mufanglin
 */
public interface TradetraTradeDao extends EntityMybatisDao<TradetraTrade> {

    @Delete("delete from tra_trade where merch_order_no=#{merchOrderNo}")
    void deleteTraTradeByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Delete("delete from tra_trade where partner_id=#{partnerId}")
    void deleteTraTradeByPartnerId(@Param("partnerId") String partnerId);

    @Select("select * from tra_trade where merch_order_no = #{merchOrderNo}")
    TradetraTrade selectTraTradeByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Update("update tra_trade set status=#{status} where merch_order_no = #{merchOrderNo}")
    void updateTraTradeByMerchOrderNoForStatus(@Param("merchOrderNo") String merchOrderNo,
                                               @Param("status") String status);

    @Update("update tra_trade set profit_status=#{profitStatus} where merch_order_no = #{merchOrderNo}")
    void updateTraTradeByMerchOrderNoForProfitStatus(@Param("merchOrderNo") String merchOrderNo,
                                                     @Param("profitStatus") String profitStatus);

    @Update("update tra_trade set recon_status=#{reconStatus} where merch_order_no = #{merchOrderNo}")
    void updateTraTradeByMerchOrderNoForReconStatus(@Param("merchOrderNo") String merchOrderNo,
                                                    @Param("reconStatus") String reconStatus);

    @Update("update tra_trade set type=#{type} where merch_order_no = #{merchOrderNo}")
    void updateTraTradeByMerchOrderNoForType(@Param("merchOrderNo") String merchOrderNo,
                                             @Param("type") String type);
}
