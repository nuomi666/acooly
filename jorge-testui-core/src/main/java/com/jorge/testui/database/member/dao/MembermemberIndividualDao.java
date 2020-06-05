/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberIndividual;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * 个体户实名认证表 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:16
 * @author mufanglin
 */
public interface MembermemberIndividualDao extends EntityMybatisDao<MembermemberIndividual> {
 @Delete("delete from member_individual where user_no = #{userNo}")
 void deleteMemberIndividualByUserNo(@Param("userNo") String userNo);
}
