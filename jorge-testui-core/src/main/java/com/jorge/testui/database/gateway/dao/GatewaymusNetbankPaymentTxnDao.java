/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.GatewaymusNetbankPaymentTxn;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * mus_netbank_payment_txn Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:04:29
 *
 * @author mufanglin
 */
public interface GatewaymusNetbankPaymentTxnDao extends EntityMybatisDao<GatewaymusNetbankPaymentTxn> {

    @Delete("delete from mus_netbank_payment_txn where gid=#{gid}")
    void deleteGatewaymusNetbankPaymentTxnByGid(@Param("gid") String gid);

    @Delete("delete from mus_netbank_payment_txn where merch_order_no=#{merchOrderNo}")
    void deleteGatewaymusNetbankPaymentTxnByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
    
    @Delete("delete from mus_netbank_payment_txn where user_id=#{userId}")
    void deleteGatewaymusNetbankPaymentTxnByUserId(@Param("userId") String userId);
    
    @Select("Select *  From mus_netbank_payment_txn where gid=#{gid} ")
    GatewaymusNetbankPaymentTxn selectGatewaymusNetbankPaymentTxnByGid(@Param("gid") String gid);

    @Update("update mus_netbank_payment_txn set status=#{status} where pay_serial_no=#{paySerialNo}")
    void updateGatewaymusNetbankPaymentTxnByGidToStatus(@Param("paySerialNo") String paySerialNo,
                                                        @Param("status") String status);
    
    @Update("update mus_netbank_payment_txn set status=#{status} , suc_amount=#{sucAmount} where gid=#{gid}")
    void updateGatewaymusNetbankPaymentTxnByGidToStatusAndSucAmount(@Param("gid") String gid,
                                                                    @Param("status") String status,@Param("sucAmount") long  sucAmount);

    @Delete("delete from mus_netbank_payment_txn where pay_serial_no=#{paySerialNo}")
    void deleteGatewaymusNetbankPaymentTxnByPaySerialNo(@Param("paySerialNo") String paySerialNo);
}
