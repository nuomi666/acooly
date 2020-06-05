/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.member.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.member.service.MembermemberBankCardService;
import com.jorge.testui.database.member.dao.MembermemberBankCardDao;
import com.jorge.testui.database.member.entity.MembermemberBankCard;

/**
 * 用户绑卡列表 Service实现
 *
 * Date: 2019-11-27 11:03:15
 *
 * @author mufanglin
 *
 */
@Service("membermemberBankCardService")
public class MembermemberBankCardServiceImpl extends EntityServiceImpl<MembermemberBankCard, MembermemberBankCardDao> implements MembermemberBankCardService {

}
