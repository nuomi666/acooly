/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.paycore.dao;

import com.jorge.testui.database.paycore.entity.PaycoreactAccountFreeze;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.paycore.entity.PaycoreactAccountFreezeChange;
import org.apache.ibatis.annotations.Select;

/**
 * 冻结账户变动表 Mybatis Dao
 *
 * Date: 2019-11-27 11:01:54
 * @author mufanglin
 */
public interface PaycoreactAccountFreezeChangeDao	extends
													EntityMybatisDao<PaycoreactAccountFreezeChange> {
	
	@Delete("delete from act_account_freeze_change where account_no = #{accountNo}")
	void deletePaycoreactAccountFreezeChangeByAccountNo(@Param("accountNo") String accountNo);
	
	@Select("select * from act_account_freeze_change where gid=#{gid} AND " +
			"account_no=#{accountNo}")
	PaycoreactAccountFreezeChange selectPaycoreactAccountFreezeChangeByGidAndAccountNo(@Param
			                                                     ("gid") String gid,@Param("accountNo") String accountNo);
	
}
