/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberPersonal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 个人用户实名认证 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:17
 * @author mufanglin
 */
public interface MembermemberPersonalDao extends EntityMybatisDao<MembermemberPersonal> {

    @Select("select * from member_personal where user_no = #{userNo}")
    MembermemberPersonal findMemberPersonalByUserNo(@Param("userNo") String userNo);
    
    @Delete("delete from member_personal where user_no =#{userNo} ")
    void deleteMembermemberPersonalByUserNo(@Param("userNo")String userNo);
    
}
