/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberAuditService;
import com.jorge.testui.database.member.dao.MembermemberAuditDao;
import com.jorge.testui.database.member.entity.MembermemberAudit;

/**
 * 会员审核表 Service实现
 *
 * Date: 2019-11-27 11:03:15
 *
 * @author mufanglin
 *
 */
@Service("membermemberAuditService")
public class MembermemberAuditServiceImpl extends EntityServiceImpl<MembermemberAudit, MembermemberAuditDao> implements MembermemberAuditService {

}
