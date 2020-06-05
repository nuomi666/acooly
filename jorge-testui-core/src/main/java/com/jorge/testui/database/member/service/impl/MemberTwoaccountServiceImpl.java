/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-03-10
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MemberTwoaccountService;
import com.jorge.testui.database.member.dao.MemberTwoaccountDao;
import com.jorge.testui.database.member.entity.MemberTwoaccount;

/**
 * 二类户开户表 Service实现
 *
 * @author mufanglin
 * @date 2020-03-10 12:27:11
 */
@Service("memberTwoaccountService")
public class MemberTwoaccountServiceImpl extends EntityServiceImpl<MemberTwoaccount, MemberTwoaccountDao> implements MemberTwoaccountService {

}
