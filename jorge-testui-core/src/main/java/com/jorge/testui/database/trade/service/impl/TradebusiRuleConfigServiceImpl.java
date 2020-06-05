/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradebusiRuleConfigService;
import com.jorge.testui.database.trade.dao.TradebusiRuleConfigDao;
import com.jorge.testui.database.trade.entity.TradebusiRuleConfig;

/**
 * 业务管控规则配置 Service实现
 *
 * Date: 2019-11-27 10:58:31
 *
 * @author mufanglin
 *
 */
@Service("tradebusiRuleConfigService")
public class TradebusiRuleConfigServiceImpl extends EntityServiceImpl<TradebusiRuleConfig, TradebusiRuleConfigDao> implements TradebusiRuleConfigService {

}
