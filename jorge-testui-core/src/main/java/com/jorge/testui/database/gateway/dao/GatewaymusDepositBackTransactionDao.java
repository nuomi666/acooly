/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.GatewaymusDepositBackTransaction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * mus_deposit_back_transaction Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:04:28
 *
 * @author mufanglin
 */
public interface GatewaymusDepositBackTransactionDao extends EntityMybatisDao<GatewaymusDepositBackTransaction> {

    @Delete("delete from mus_deposit_back_transaction where merch_order_no=#{merchOrderNo}")
    void deleteGatewaymusDepositBackTransactionMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Select("select * from mus_deposit_back_transaction where merch_order_no=#{merchOrderNo}")
    GatewaymusDepositBackTransaction selectGatewaymusDepositBackTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);

    @Update("update mus_deposit_back_transaction set status=#{status} where merch_order_no=#{merchOrderNo}")
    void updateGatewaymusDepositBackTransactionMerchOrderNo(@Param("merchOrderNo") String merchOrderNo,
                                                            @Param("status") String status);

    @Delete("delete from mus_deposit_back_transaction where old_biz_order_no =#{oldBizOrderNo}")
    void deleteGatewaymusDepositBackTransactionByOldBizOrderNo(@Param("oldBizOrderNo") String oldBizOrderNo);

    @Select("select * from mus_deposit_back_transaction where deposit_serial_no=#{depositSerialNo}")
    GatewaymusDepositBackTransaction findGatewaymusDepositBackTransactionByDepositSerialNo(@Param("depositSerialNo")String depositSerialNo);

}
