/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-05
 */
package com.jorge.testui.database.bill.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.bill.entity.ReconPeriod;

/**
 * 每日对账结果 Mybatis Dao
 *
 * Date: 2019-12-05 09:52:01
 * @author mufanglin
 */
public interface ReconPeriodDao extends EntityMybatisDao<ReconPeriod> {
	
	@Delete("delete from  recon_period where period_no=#{periodNo}")
	void deleteReconPeriodByPeriodNo(@Param("periodNo") String periodNo);
}
