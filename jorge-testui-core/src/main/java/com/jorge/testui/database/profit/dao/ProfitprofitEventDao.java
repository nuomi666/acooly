/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.profit.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.profit.entity.ProfitprofitEvent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * profit_event Mybatis Dao
 * <p>
 * Date: 2019-11-27 11:05:03
 *
 * @author mufanglin
 */
public interface ProfitprofitEventDao extends EntityMybatisDao<ProfitprofitEvent> {

    @Update("update profit_event set default_account_no=#{defaultAccountNo} where event_type=#{eventType}")
    void updateProfitprofitEventByEventTypeToAccountNo(@Param("eventType") String eventType,
                                                       @Param("defaultAccountNo") String defaultAccountNo);

    @Select("select * from profit_event where event_type=#{eventType}")
    ProfitprofitEvent selectProfitprofitEventByEventType(@Param("eventType") String eventType);

    @Select("select * from profit_event where partner_id=#{partnerId}")
    ProfitprofitEvent selectProfitprofitEventByPartnerId(@Param("partnerId") String partnerId);

    @Delete("delete from profit_event where id = #{eventId}")
    void deleteProfitprofitEventById(@Param("eventId") Long eventId);

    @Delete("delete from profit_event")
    void deleteProfitprofitEventByAll();
}
