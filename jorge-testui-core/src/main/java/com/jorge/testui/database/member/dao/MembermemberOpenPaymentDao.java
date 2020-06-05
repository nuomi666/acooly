/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberOpenPayment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 会员支付能力 Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:03:16
 *
 * @author mufanglin
 */
public interface MembermemberOpenPaymentDao extends EntityMybatisDao<MembermemberOpenPayment> {

    @Select("select * from member_open_payment where user_no=#{userNo} and payment_type=#{paymentType}")
    MembermemberOpenPayment selectMembermemberOpenPaymentByUserNoAndPmentType(@Param("userNo") String userNo,
                                                                              @Param("paymentType") String paymentType);

    @Delete("delete from member_open_payment where user_no = #{userNo}")
    void deleteMemberOpenPaymentByUserNo(@Param("userNo") String userNo);


    @Delete("delete from member_open_payment where user_no = #{userNo} and payment_type= #{paymentType}")
    void deleteMemberOpenPaymentByUserNoAndPaymentType(@Param("userNo") String userNo,@Param("paymentType") String paymentType);

}
