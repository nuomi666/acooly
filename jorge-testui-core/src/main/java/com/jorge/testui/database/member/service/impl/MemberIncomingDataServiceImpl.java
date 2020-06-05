/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-19
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MemberIncomingDataService;
import com.jorge.testui.database.member.dao.MemberIncomingDataDao;
import com.jorge.testui.database.member.entity.MemberIncomingData;

/**
 * 会员进件资料表 Service实现
 *
 * Date: 2019-12-19 15:24:41
 *
 * @author mufanglin
 *
 */
@Service("memberIncomingDataService")
public class MemberIncomingDataServiceImpl extends EntityServiceImpl<MemberIncomingData, MemberIncomingDataDao> implements MemberIncomingDataService {

}
