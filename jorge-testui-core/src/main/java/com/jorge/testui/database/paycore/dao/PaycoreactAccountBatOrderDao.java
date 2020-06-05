/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountBatOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * 账务系统批量订单表 Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:01:53
 *
 * @author mufanglin
 */
public interface PaycoreactAccountBatOrderDao extends EntityMybatisDao<PaycoreactAccountBatOrder> {

    @Delete("delete from act_account_bat_order where merch_order_no = #{merchOrderNo}")
    void deletePaycoreactAccountBatOrderByMerchOrderNo(@Param("merchOrderNo") String merchOrderNo);
    
    @Delete("delete from act_account_bat_order where gid = #{gid}")
    void deletePaycoreactAccountBatOrderByGid(@Param("gid") String gid);
    
}
