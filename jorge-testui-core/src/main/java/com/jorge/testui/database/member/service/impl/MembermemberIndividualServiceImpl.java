/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberIndividualService;
import com.jorge.testui.database.member.dao.MembermemberIndividualDao;
import com.jorge.testui.database.member.entity.MembermemberIndividual;

/**
 * 个体户实名认证表 Service实现
 *
 * Date: 2019-11-27 11:03:16
 *
 * @author mufanglin
 *
 */
@Service("membermemberIndividualService")
public class MembermemberIndividualServiceImpl extends EntityServiceImpl<MembermemberIndividual, MembermemberIndividualDao> implements MembermemberIndividualService {

}
