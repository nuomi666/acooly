/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-19
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MemberIncomingData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 会员进件资料表 Mybatis Dao
 *
 * Date: 2019-12-19 15:24:40
 * @author mufanglin
 */
public interface MemberIncomingDataDao extends EntityMybatisDao<MemberIncomingData> {

     @Select("SELECT * FROM member_incoming_data WHERE user_no = #{userNo}")
     MemberIncomingData selectMemberIncomingDataByUserNo(@Param("userNo") String userNo);

     @Delete("DELETE FROM member_incoming_data WHERE user_no = #{userNo}")
     void deleteMemberIncomingDataByUserNo(@Param("userNo") String userNo);

     @Update("UPDATE member_incoming_data SET audit_status= #{auditStatus} WHERE user_no = #{userNo}")
     void updateMemberIncomingDataByUserNo(@Param("userNo") String userNo,@Param("auditStatus") String auditStatus);


     @Delete("DELETE FROM member_incoming_data WHERE contact_mobile = #{contactMobile}")
     void deleteMemberIncomingDataByMobile(@Param("contactMobile") String contactMobile);


     @Delete("DELETE FROM member_incoming_data WHERE contact_email = #{contactEmail}")
     void deleteMemberIncomingDataByEmail(@Param("contactEmail") String contactEmail);
}
