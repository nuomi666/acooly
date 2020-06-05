/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberOperator;

/**
 * 操作员管理表 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:17
 * @author mufanglin
 */
public interface MembermemberOperatorDao extends EntityMybatisDao<MembermemberOperator> {
	
	@Delete("delete from member_operator where user_no = #{userNo}")
	void deleteMembermemberOperatorByUserNo(@Param("userNo") String userNo);
}
