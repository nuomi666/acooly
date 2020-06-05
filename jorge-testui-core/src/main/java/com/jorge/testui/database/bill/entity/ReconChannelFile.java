/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-05
*/
package com.jorge.testui.database.bill.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * 对账文件下载记录表 Entity
 *
 * @author mufanglin
 * Date: 2019-12-05 09:52:01
 */
@Entity
@Table(name = "recon_channel_file")
@Getter
@Setter
public class ReconChannelFile extends AbstractEntity {

    /**
     * 账期
     */
	@NotEmpty
	@Size(max = 32)
    private String periodNo;

    /**
     * 渠道类型
     */
	@NotEmpty
	@Size(max = 64)
    private String channelType;

    /**
     * 商户号
     */
	@Size(max = 64)
    private String partnerId;

    /**
     * 文件路径
     */
	@Size(max = 255)
    private String filePath;

    /**
     * 文件下载状态
     */
	@Size(max = 64)
    private String downFileStatus;

    /**
     * 文件下载备注
     */
	@Size(max = 255)
    private String downFileMemo;

    /**
     * 数据解析状态
     */
	@Size(max = 64)
    private String dataInsertStatus;

    /**
     * 数据解析条数
     */
    private Long dataInsertNo;

    /**
     * 数据解析备注
     */
	@Size(max = 255)
    private String dataInsertMemo;

}
