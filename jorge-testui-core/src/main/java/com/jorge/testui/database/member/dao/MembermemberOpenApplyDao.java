/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberOpenApply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 会员开通支付能力申请订单 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:16
 * @author mufanglin
 */
public interface MembermemberOpenApplyDao extends EntityMybatisDao<MembermemberOpenApply> {
 @Delete("delete from member_open_apply where user_no = #{userNo} and payment_type= #{paymentType}")
 void deleteMemberOpenApplyByUserNoAndPaymentType(@Param("userNo") String userNo,@Param("paymentType") String paymentType);

 @Select("SELECT * FROM member_open_apply WHERE user_no = #{userNo}")
 List<MembermemberOpenApply> findMemberOpenApplyByUserNo(@Param("userNo") String userNo);
}
