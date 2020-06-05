/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberAuthAuditService;
import com.jorge.testui.database.member.dao.MembermemberAuthAuditDao;
import com.jorge.testui.database.member.entity.MembermemberAuthAudit;

/**
 * 用户实名审核表 Service实现
 *
 * Date: 2019-11-27 11:03:15
 *
 * @author mufanglin
 *
 */
@Service("membermemberAuthAuditService")
public class MembermemberAuthAuditServiceImpl extends EntityServiceImpl<MembermemberAuthAudit, MembermemberAuthAuditDao> implements MembermemberAuthAuditService {

}
