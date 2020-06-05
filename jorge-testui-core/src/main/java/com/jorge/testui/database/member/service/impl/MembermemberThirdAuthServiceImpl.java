/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberThirdAuthService;
import com.jorge.testui.database.member.dao.MembermemberThirdAuthDao;
import com.jorge.testui.database.member.entity.MembermemberThirdAuth;

/**
 * 会员第三方认证表 Service实现
 *
 * Date: 2019-11-27 11:03:17
 *
 * @author mufanglin
 *
 */
@Service("membermemberThirdAuthService")
public class MembermemberThirdAuthServiceImpl extends EntityServiceImpl<MembermemberThirdAuth, MembermemberThirdAuthDao> implements MembermemberThirdAuthService {

}
