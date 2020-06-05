/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberOpenApplyService;
import com.jorge.testui.database.member.dao.MembermemberOpenApplyDao;
import com.jorge.testui.database.member.entity.MembermemberOpenApply;

/**
 * 会员开通支付能力申请订单 Service实现
 *
 * Date: 2019-11-27 11:03:16
 *
 * @author mufanglin
 *
 */
@Service("membermemberOpenApplyService")
public class MembermemberOpenApplyServiceImpl extends EntityServiceImpl<MembermemberOpenApply, MembermemberOpenApplyDao> implements MembermemberOpenApplyService {

}
