/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-11
 */
package com.jorge.testui.database.openapi.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.openapi.entity.ApiNotifyMessage;
import com.jorge.testui.database.paycore.entity.PaycoreactAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * api_notify_message Mybatis Dao
 * <p>
 * Date: 2019-12-11 10:58:11
 *
 * @author mufanglin
 */
public interface ApiNotifyMessageDao extends EntityMybatisDao<ApiNotifyMessage> {

    @Delete("delete from api_notify_message where  partner_id=#{partnerId}")
    void deleteApiNotifyMessageByPartnerId(@Param("partnerId") String partnerId);
    
    @Select("select * from api_notify_message where gid=#{gid}")
    ApiNotifyMessage selectApiNotifyMessageBygid(@Param("gid") String gid);
    
}
