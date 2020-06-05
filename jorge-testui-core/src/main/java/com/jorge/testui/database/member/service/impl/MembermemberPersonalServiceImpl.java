/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberPersonalService;
import com.jorge.testui.database.member.dao.MembermemberPersonalDao;
import com.jorge.testui.database.member.entity.MembermemberPersonal;

/**
 * 个人用户实名认证 Service实现
 *
 * Date: 2019-11-27 11:03:17
 *
 * @author mufanglin
 *
 */
@Service("membermemberPersonalService")
public class MembermemberPersonalServiceImpl extends EntityServiceImpl<MembermemberPersonal, MembermemberPersonalDao> implements MembermemberPersonalService {

}
