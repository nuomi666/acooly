/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-03-10
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MemberTwoaccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 二类户开户表 Mybatis Dao
 *
 * @author mufanglin
 * @date 2020-03-10 12:27:11
 */
public interface MemberTwoaccountDao extends EntityMybatisDao<MemberTwoaccount> {

 @Select("select * from member_twoaccount where user_no = #{userNo}")
 MemberTwoaccount findMemberTwoaccountByUserNo(@Param("userNo") String userNo);

 @Delete("delete from member_twoaccount where user_no = #{userNo}")
 void deleteMemberTwoaccountByUserNo(@Param("userNo") String userNo);
}
