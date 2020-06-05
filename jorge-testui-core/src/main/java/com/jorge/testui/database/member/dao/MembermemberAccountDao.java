/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户资金账户 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:14
 * @author mufanglin
 */
public interface MembermemberAccountDao extends EntityMybatisDao<MembermemberAccount> {
 
 @Delete("delete from member_account where user_no = #{userNo}")
 void deleteMembermemberAccountByUserNo(@Param("userNo") String userNo);

 @Delete("delete from member_account where account_no = #{accountNo}")
 void deleteMembermemberAccountByAccountNo(@Param("accountNo") String accountNo);

 @Select("SELECT * FROM member_account WHERE user_no = #{userNo} AND account_type = #{accountType} ")
 MembermemberAccount selectMembermemberAccountByUserNoAndAccountType(@Param("userNo") String userNo,@Param("accountType") String accountType);

 @Select("SELECT * FROM member_account WHERE account_no = #{accountNo}")
 MembermemberAccount selectMembermemberAccountByAccountNo(@Param("accountNo") String accountNo);
}
