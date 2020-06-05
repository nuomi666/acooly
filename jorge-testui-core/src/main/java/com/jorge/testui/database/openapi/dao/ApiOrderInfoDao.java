/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-11
 */
package com.jorge.testui.database.openapi.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.database.openapi.entity.ApiOrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 请求信息表 Mybatis Dao
 * <p>
 * Date: 2019-12-11 10:58:11
 *
 * @author mufanglin
 */
public interface ApiOrderInfoDao extends EntityMybatisDao<ApiOrderInfo> {

    @Delete("delete from api_order_info where  partner_id=#{partnerId}")
    void deleteApiOrderInfoByPartnerId(@Param("partnerId") String partnerId);

    @Select("select * from api_order_info where  partner_id=#{partnerId}")
    List<ApiOrderInfo> selectApiOrderInfoByPartnerId(@Param("partnerId") String partnerId);
}
