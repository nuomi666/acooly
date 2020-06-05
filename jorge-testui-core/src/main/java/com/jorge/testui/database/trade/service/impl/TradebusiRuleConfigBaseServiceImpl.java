/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-27
 */
package com.jorge.testui.database.trade.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.trade.service.TradebusiRuleConfigBaseService;
import com.jorge.testui.database.trade.dao.TradebusiRuleConfigBaseDao;
import com.jorge.testui.database.trade.entity.TradebusiRuleConfigBase;

/**
 * 业务管控基础规则配置 Service实现
 *
 * Date: 2019-11-27 10:58:31
 *
 * @author mufanglin
 *
 */
@Service("tradebusiRuleConfigBaseService")
public class TradebusiRuleConfigBaseServiceImpl extends EntityServiceImpl<TradebusiRuleConfigBase, TradebusiRuleConfigBaseDao> implements TradebusiRuleConfigBaseService {

}
