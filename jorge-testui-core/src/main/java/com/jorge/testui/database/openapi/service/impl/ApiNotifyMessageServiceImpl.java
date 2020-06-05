/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-11
 */
package com.jorge.testui.database.openapi.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.openapi.service.ApiNotifyMessageService;
import com.jorge.testui.database.openapi.dao.ApiNotifyMessageDao;
import com.jorge.testui.database.openapi.entity.ApiNotifyMessage;

/**
 * api_notify_message Service实现
 *
 * Date: 2019-12-11 10:58:11
 *
 * @author mufanglin
 *
 */
@Service("apiNotifyMessageService")
public class ApiNotifyMessageServiceImpl extends EntityServiceImpl<ApiNotifyMessage, ApiNotifyMessageDao> implements ApiNotifyMessageService {

}
