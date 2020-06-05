/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.gateway.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.gateway.entity.GatewaymusGatewayDeductTransaction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * mus_gateway_deduct_transaction Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:04:29
 *
 * @author mufanglin
 */
public interface GatewaymusGatewayDeductTransactionDao	extends
														EntityMybatisDao<GatewaymusGatewayDeductTransaction> {
	
	@Delete("delete from mus_gateway_deduct_transaction where gid=#{gid}")
	void deleteGatewaymusGatewayDeductTransactionByGid(@Param("gid") String gid);

	@Delete("delete from mus_gateway_deduct_transaction where merch_order_no=#{merchOrderNo}")
	void deleteGatewaymusGatewayDeductTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
	
	@Select("Select *  From mus_gateway_deduct_transaction where gid=#{gid} ")
	GatewaymusGatewayDeductTransaction selectGatewaymusGatewayDeductTransactionByGid(@Param("gid") String gid);

	@Select("Select *  From mus_gateway_deduct_transaction where merch_order_no=#{merchOrderNo} ")
	GatewaymusGatewayDeductTransaction selectGatewaymusGatewayDeductTransactionByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);


	@Update("update mus_gateway_deduct_transaction set status=#{status} where gid=#{gid}")
	void updateGatewaymusGatewayDeductTransactionByGid(	@Param("gid") String gid,
														@Param("status") String status);
	
	@Update("update mus_gateway_deduct_transaction set status=#{status} where settle_serial_no=#{settleSerialNo}")
	void updateGatewaymusGatewayDeductTransactionBySettleSerialNo(	@Param("settleSerialNo") String settleSerialNo,
																	@Param("status") String status);
}
