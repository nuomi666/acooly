/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberAuthAudit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * 用户实名审核表 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:15
 * @author mufanglin
 */
public interface MembermemberAuthAuditDao extends EntityMybatisDao<MembermemberAuthAudit> {
 @Delete("delete from member_auth_audit where user_no =#{userNo}")
 void deleteMemberAuthAuditByUserNo(@Param("userNo")String userNo);
}
