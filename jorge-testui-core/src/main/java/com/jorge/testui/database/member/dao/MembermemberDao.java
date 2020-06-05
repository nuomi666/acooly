/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.Membermember;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 用户信息表 Mybatis Dao
 * <p>
 * Date: 2019-11-29 11:03:14
 *
 * @author zhoudling
 */
public interface MembermemberDao extends EntityMybatisDao<Membermember> {

    @Update("update member set member_status=#{memberStatus} where user_no =#{userNo}")
    void updateByUserNo(@Param("userNo")String userNo,@Param("memberStatus")String memberStatus);

    @Update("update member set member_status = #{memberStatus},real_name_auth = #{realNameAuth} where user_no =#{userNo}")
    void updateMemberStatusAndRealNameAuthByUserNo(@Param("userNo")String userNo,@Param("memberStatus")String memberStatus,@Param("realNameAuth")String realNameAuth);

    @Delete("delete from member where user_no = #{userNo}")
    void deleteMembermemberByUserNo(@Param("userNo") String userNo);

    @Select("select * from member where user_no = #{userNo}")
    Membermember findMemberByUserNo(@Param("userNo") String userNo);

    @Select("select * from member where merch_user_no = #{merchUserNo} and partner_id = #{partnerId} and " +
            "member_status='ENABLE' ")
    Membermember findEnabelMemberByMerchUserNoAndPartnerId(@Param("merchUserNo") String merchUserNo,
                                                      @Param("partnerId") String partnerId);

    @Delete("delete from member where merch_user_no = #{merchUserNo} and partner_id=#{partnerId}")
    void deleteMembermemberByMerchUserNoAndPartnerId(@Param("merchUserNo") String merchUserNo,@Param("partnerId") String partnerId);

}
