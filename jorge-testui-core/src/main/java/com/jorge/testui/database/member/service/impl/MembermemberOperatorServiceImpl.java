/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberOperatorService;
import com.jorge.testui.database.member.dao.MembermemberOperatorDao;
import com.jorge.testui.database.member.entity.MembermemberOperator;

/**
 * 操作员管理表 Service实现
 *
 * Date: 2019-11-27 11:03:17
 *
 * @author mufanglin
 *
 */
@Service("membermemberOperatorService")
public class MembermemberOperatorServiceImpl extends EntityServiceImpl<MembermemberOperator, MembermemberOperatorDao> implements MembermemberOperatorService {

}
