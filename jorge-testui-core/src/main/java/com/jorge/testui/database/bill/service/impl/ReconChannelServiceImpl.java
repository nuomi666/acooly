/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-05
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.ReconChannelService;
import com.jorge.testui.database.bill.dao.ReconChannelDao;
import com.jorge.testui.database.bill.entity.ReconChannel;

/**
 * 渠道配置表 Service实现
 *
 * Date: 2019-12-05 09:52:01
 *
 * @author mufanglin
 *
 */
@Service("reconChannelService")
public class ReconChannelServiceImpl extends EntityServiceImpl<ReconChannel, ReconChannelDao> implements ReconChannelService {

}
