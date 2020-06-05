/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitprofitSection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * profit_section Mybatis Dao
 *
 * Date: 2019-11-27 11:05:03
 * @author mufanglin
 */
public interface ProfitprofitSectionDao extends EntityMybatisDao<ProfitprofitSection> {
	
	@Select("select * from profit_section where section_name=#{sectionName}")
	ProfitprofitSection selectProfitprofitSectionBySectionName(@Param("sectionName") String sectionName);
	
	@Select("select * from profit_section where event_id=#{eventId}")
	ProfitprofitSection selectProfitprofitSectionByEventId(@Param("eventId") Long eventId);
	
	@Delete("delete from profit_section where id =#{sectionId}")
	void deleteProfitprofitSectionById(@Param("sectionId") Long sectionId);
	
	@Delete("delete from profit_section")
	void deleteProfitprofitSectionByAll();
}
