/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitprofitActionRule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * profit_action_rule Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:05:02
 *
 * @author mufanglin
 */
public interface ProfitprofitActionRuleDao extends EntityMybatisDao<ProfitprofitActionRule> {

    @Update("UPDATE profit_action_rule SET cal_rate=#{calRate} where section_id=#{sectionId}")
    void updateProfitprofitActionRuleBySectionId(@Param("sectionId") String sectionId,
                                                 @Param("calRate") String calRate);

    @Update("UPDATE profit_action_rule SET cal_rate=#{calRate},cal_type=#{calType} where section_id=#{sectionId}")
    void updateProfitprofitActionRuleBySectionIdUpdateAalRateAndCalType(@Param("sectionId") String sectionId,
                                                                        @Param("calRate") String calRate, @Param("calType") String calType);
    
    @Select("select * from profit_action_rule where section_id=#{sectionId}")
    ProfitprofitActionRule selectProfitprofitActionRuleBySectionId(@Param("sectionId") String
                                                                             sectionId);

    @Delete("delete from profit_action_rule where id =#{id}")
    void deleteProfitActionRuleById(@Param("id")Long id);

    @Delete("delete from profit_action_rule ")
    void deleteProfitActionRuleByAll();
    
}
