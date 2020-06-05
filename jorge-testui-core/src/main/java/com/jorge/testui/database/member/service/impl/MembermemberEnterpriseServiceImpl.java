/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberEnterpriseService;
import com.jorge.testui.database.member.dao.MembermemberEnterpriseDao;
import com.jorge.testui.database.member.entity.MembermemberEnterprise;

/**
 * 企业用户实名认证 Service实现
 *
 * Date: 2019-11-27 11:03:16
 *
 * @author mufanglin
 *
 */
@Service("membermemberEnterpriseService")
public class MembermemberEnterpriseServiceImpl extends EntityServiceImpl<MembermemberEnterprise, MembermemberEnterpriseDao> implements MembermemberEnterpriseService {

}
