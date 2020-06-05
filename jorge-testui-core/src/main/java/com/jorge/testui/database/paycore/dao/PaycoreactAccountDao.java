/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.dao;

import com.acooly.core.utils.Money;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccount;
import org.apache.ibatis.annotations.Update;

/**
 * 用户账户 Mybatis Dao
 *
 * Date: 2019-11-27 11:01:53
 * @author mufanglin
 */
public interface PaycoreactAccountDao extends EntityMybatisDao<PaycoreactAccount> {
	
	@Select("select * from act_account where user_no=#{userNo} and account_no=#{accountNo}")
	PaycoreactAccount selectActAccountByUserNoAndAccountNo(	@Param("userNo") String userNo,
															@Param("accountNo") String accountNo);
															
	@Delete("delete from act_account where user_no = #{userNo}")
	void deletePaycoreactAccountByUserNo(@Param("userNo") String userNo);
	
	@Select("select * from act_account where account_no=#{accountNo}")
	PaycoreactAccount selectPaycoreactAccountByAccountNo(@Param("accountNo") String accountNo);

	/**
	 * 根据账户号更新账户余额和冻结金额
	 * @param balance 余额
	 * @param freeze 冻结金额
	 * @param accountNo 账户号
	 */
	@Update("UPDATE act_account SET balance = #{balance}, freeze = #{freeze}  where account_no=#{accountNo}")
	void updatePaycoreactAccountByAccountNo(@Param("balance") Money balance, @Param("freeze") Money freeze, @Param("accountNo") String accountNo);

	/**
	 * 根据账户号更新账户余额和冻结金额为0
	 * @param accountNo
	 */
	@Update("UPDATE act_account SET balance = 0, freeze = 0  where account_no=#{accountNo}")
	void updatePaycoreactAccountBalanceToZeroByAccountNo( @Param("accountNo") String accountNo);

	@Delete("delete from act_account where account_no = #{accountNo}")
	void deletePaycoreactAccountByAccountNo(@Param("accountNo") String accountNo);
	
	@Select("select * from act_account where user_no=#{userNo} and account_type=#{accountType}")
	PaycoreactAccount selectActAccountByUserNoAndAccountType(	@Param("userNo") String userNo,
	                                                           @Param("accountType") String accountType);
	
	@Select("select * from act_account where user_no=#{userNo}")
	PaycoreactAccount selectActAccountByUserNo(	@Param("userNo") String userNo);
}
