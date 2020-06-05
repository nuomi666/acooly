/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-02-19
 */
 package com.jorge.testui.database.bill.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.bill.entity.FunFund;
import com.jorge.testui.database.bill.entity.TraTradeProfit;
import com.jorge.testui.database.trade.entity.TradetraTradeProfit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 充值提现订单 Mybatis Dao
 *
 * @author mufanglin
 * @date 2020-02-19 14:45:17
 */
public interface FunFundDao extends EntityMybatisDao<FunFund> {
 @Delete("delete from fun_fund where merch_order_no=#{merchOrderNo}")
 void deleteFunFundByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
 
 @Delete("delete from fun_fund where gid=#{gid}")
 void deleteFunFundByGid(@Param("gid") String gid);
 
 @Delete("delete from fun_fund where period_no=#{periodNo}")
 void deleteFunFundByPeriodNo(@Param("periodNo") String periodNo);
 
 @Select("select *  from fun_fund where merch_order_no=#{merchOrderNo}")
 FunFund selectFunFundByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
}
