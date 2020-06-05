/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberOpenPaymentService;
import com.jorge.testui.database.member.dao.MembermemberOpenPaymentDao;
import com.jorge.testui.database.member.entity.MembermemberOpenPayment;

/**
 * 会员支付能力 Service实现
 *
 * Date: 2019-11-27 11:03:16
 *
 * @author mufanglin
 *
 */
@Service("membermemberOpenPaymentService")
public class MembermemberOpenPaymentServiceImpl extends EntityServiceImpl<MembermemberOpenPayment, MembermemberOpenPaymentDao> implements MembermemberOpenPaymentService {

}
