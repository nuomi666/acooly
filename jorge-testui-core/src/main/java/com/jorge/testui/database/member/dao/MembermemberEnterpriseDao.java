/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberEnterprise;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * 企业用户实名认证 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:16
 * @author mufanglin
 */
public interface MembermemberEnterpriseDao extends EntityMybatisDao<MembermemberEnterprise> {
 @Delete("delete from member_enterprise where user_no = #{userNo}")
 void deleteMemberEnterpriseByUserNo(@Param("userNo") String userNo);
}
