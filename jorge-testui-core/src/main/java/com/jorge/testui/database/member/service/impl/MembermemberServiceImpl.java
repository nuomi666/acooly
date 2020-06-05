/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberService;
import com.jorge.testui.database.member.dao.MembermemberDao;
import com.jorge.testui.database.member.entity.Membermember;

/**
 * 用户信息表 Service实现
 *
 * Date: 2019-11-27 11:03:14
 *
 * @author mufanglin
 *
 */
@Service("membermemberService")
public class MembermemberServiceImpl extends EntityServiceImpl<Membermember, MembermemberDao> implements MembermemberService {

}
