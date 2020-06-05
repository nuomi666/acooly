/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
 package com.jorge.testui.database.member.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.member.entity.MembermemberBankCard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户绑卡列表 Mybatis Dao
 *
 * Date: 2019-11-27 11:03:15
 * @author mufanglin
 */
public interface MembermemberBankCardDao extends EntityMybatisDao<MembermemberBankCard> {
 /**
  * 根据用例编号查询参数
  * @param userNo
  * @param bankCardNo
  * @return
  */
 @Delete("delete from member_bank_card where user_no =#{userNo} and bank_card_no =#{bankCardNo}")
 void deleteMemberBankCardByUserNoAndBankCardNo(@Param("userNo")String userNo,@Param("bankCardNo")String bankCardNo);

 @Select("select * from member_bank_card where user_no =#{userNo} and bank_card_no =#{bankCardNo}")
 MembermemberBankCard findMemberBankCardByUserNoAndBankCardNo(@Param("userNo")String userNo,@Param("bankCardNo")String bankCardNo);

 @Select("select * from member_bank_card where user_no =#{userNo} and bind_type =#{bindType}")
 MembermemberBankCard findMemberBankCardByUserNoAndBindType(@Param("userNo")String userNo,@Param("bindType")String bindType);

 @Select("select * from member_bank_card where user_no =#{userNo} and purpose =#{purpose}")
 MembermemberBankCard findMemberBankCardByUserNoAndPurpose(@Param("userNo")String userNo,
                                                        @Param("purpose")String purpose);

 @Select("SELECT * FROM member_bank_card WHERE bank_card_no = #{bankCardNo} AND card_status ='ENABLE'")
 List<MembermemberBankCard> findEnableCardByBankCardNo(@Param("bankCardNo")String bankCardNo);

 @Select("SELECT * FROM member_bank_card WHERE bind_no = #{bindNo}")
 MembermemberBankCard findMembermemberBankCardByBindNo(@Param("bindNo")String bindNo);

 @Select("SELECT * FROM member_bank_card WHERE user_no = #{userNo} and bind_type = #{bindType} and card_status = #{cardStatus}")
 MembermemberBankCard findMemberBankCardByUserNoAndBindTypeAndCardStatus(@Param("userNo")String userNo,@Param("bindType")String bindType,@Param("cardStatus")String cardStatus);

 @Delete("delete from member_bank_card where user_no =#{userNo} ")
 void deleteMembermemberBankCardByUserNo(@Param("userNo")String userNo);

 @Delete("delete from member_bank_card where bind_no =#{bindNo} ")
 void deleteMembermemberBankCardByBindNo(@Param("bindNo")String bindNo);

 @Update("UPDATE member_bank_card SET card_status = #{cardStatus} WHERE user_no = #{userNo} and bank_card_no = #{bankCardNo}")
 void updateCardStatusMembermemberBankCardByUserNoAndBankCardNo(@Param("cardStatus")String cardStatus,@Param("userNo")String userNo,@Param("bankCardNo")String bankCardNo);

 @Update("UPDATE member_bank_card SET card_status = #{cardStatus} WHERE bind_no = #{bindNo}")
 void updateCardStatusMemberBankCardByBindNo(@Param("cardStatus")String cardStatus,@Param("bindNo")String bindNo);
}
