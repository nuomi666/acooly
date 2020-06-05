/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-05
 */
package com.jorge.testui.database.bill.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.database.bill.service.ReconChannelFileService;
import com.jorge.testui.database.bill.dao.ReconChannelFileDao;
import com.jorge.testui.database.bill.entity.ReconChannelFile;

/**
 * 对账文件下载记录表 Service实现
 *
 * Date: 2019-12-05 09:52:01
 *
 * @author mufanglin
 *
 */
@Service("reconChannelFileService")
public class ReconChannelFileServiceImpl extends EntityServiceImpl<ReconChannelFile, ReconChannelFileDao> implements ReconChannelFileService {

}
