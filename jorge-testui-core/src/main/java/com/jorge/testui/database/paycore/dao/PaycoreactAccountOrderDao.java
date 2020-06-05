/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 账务系统订单表 Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:01:55
 *
 * @author mufanglin
 */
public interface PaycoreactAccountOrderDao extends EntityMybatisDao<PaycoreactAccountOrder> {


    @Delete("delete from act_account_order where user_no = #{userNo}")
    void deletePaycoreactAccountOrderByUserNo(@Param("userNo") String userNo);

    @Select("select * from act_account_order where gid=#{gid}")
    PaycoreactAccountOrder selectPaycoreactAccountOrderByGid(@Param("gid") String gid);
    
    @Select("select * from act_account_order where gid=#{gid} and order_type = #{orderType}")
    PaycoreactAccountOrder selectPaycoreactAccountOrderByGidAndOrderType(@Param("gid") String
                                        gid,@Param("orderType") String orderType);
    
    @Delete("delete from act_account_order where partner_id = #{partnerId}")
    void deletePaycoreactAccountOrderpartnerId(@Param("partnerId") String partnerId);
    
    @Delete("delete from act_account_order where gid = #{gid}")
    void deletePaycoreactAccountOrderByGid(@Param("gid") String gid);
    
}
