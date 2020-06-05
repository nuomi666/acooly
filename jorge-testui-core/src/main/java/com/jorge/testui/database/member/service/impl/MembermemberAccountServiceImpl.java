/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberAccountService;
import com.jorge.testui.database.member.dao.MembermemberAccountDao;
import com.jorge.testui.database.member.entity.MembermemberAccount;

/**
 * 用户资金账户 Service实现
 *
 * Date: 2019-11-27 11:03:14
 *
 * @author mufanglin
 *
 */
@Service("membermemberAccountService")
public class MembermemberAccountServiceImpl extends EntityServiceImpl<MembermemberAccount, MembermemberAccountDao> implements MembermemberAccountService {

}
