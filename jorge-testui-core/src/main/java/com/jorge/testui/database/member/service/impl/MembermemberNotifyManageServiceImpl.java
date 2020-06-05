/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberNotifyManageService;
import com.jorge.testui.database.member.dao.MembermemberNotifyManageDao;
import com.jorge.testui.database.member.entity.MembermemberNotifyManage;

/**
 * 商户通知地址管理 Service实现
 *
 * Date: 2019-11-27 11:03:16
 *
 * @author mufanglin
 *
 */
@Service("membermemberNotifyManageService")
public class MembermemberNotifyManageServiceImpl extends EntityServiceImpl<MembermemberNotifyManage, MembermemberNotifyManageDao> implements MembermemberNotifyManageService {

}
