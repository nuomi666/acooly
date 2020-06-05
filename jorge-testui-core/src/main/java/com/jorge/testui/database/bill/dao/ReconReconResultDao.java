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
import com.jorge.testui.database.bill.entity.ReconReconResult;

/**
 * 对账结果记录表 Mybatis Dao
 *
 * Date: 2019-12-05 09:52:02
 * @author mufanglin
 */
public interface ReconReconResultDao extends EntityMybatisDao<ReconReconResult> {
	
	@Delete("delete from recon_recon_result where gid=#{gid}")
	void deleteReconReconResultByGid(@Param("gid") String gid);

	@Delete("delete from recon_recon_result")
	void deleteReconReconResultAll();
}
