/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.GatewaymusWithdrawTransaction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * mus_withdraw_transaction Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:04:31
 *
 * @author mufanglin
 */
public interface GatewaymusWithdrawTransactionDao extends EntityMybatisDao<GatewaymusWithdrawTransaction> {
    @Delete("delete from mus_withdraw_transaction where merch_order_no=#{merchOrderNo}")
    void deleteGatewaymusWithdrawTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Select("select * from mus_withdraw_transaction where merch_order_no=#{merchOrderNo}")
    GatewaymusWithdrawTransaction selectGatewaymusWithdrawTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Update("update mus_withdraw_transaction set status=#{status} where merch_order_no=#{merchOrderNo}")
    void updateGatewaymusWithdrawTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo,
                                                           @Param("status") String status);

    @Update("update mus_withdraw_transaction set status=#{status} where settle_serial_no=#{settleSerialNo}")
    void updateGatewaymusWithdrawTransactionBySettleSerialNo(@Param("settleSerialNo") String settleSerialNo,
                                                           @Param("status") String status);
    
    @Delete("delete from mus_withdraw_transaction where gid=#{gid}")
    void deleteGatewaymusWithdrawTransactionByGid(@Param("gid") String gid);
    
}
