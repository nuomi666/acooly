/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-27
*/
package com.jorge.testui.database.member.entity;


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
 * 商户通知地址管理 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:16
 */
@Entity
@Table(name = "member_notify_manage")
@Getter
@Setter
public class MembermemberNotifyManage extends AbstractEntity {

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 外部用户唯一ID
     */
	@Size(max = 64)
    private String merchUserNo;

    /**
     * 类型
     */
	@Size(max = 16)
    private String memberType;

    /**
     * 通知类型
     */
	@NotEmpty
	@Size(max = 64)
    private String notifyType;

    /**
     * 通知地址
     */
	@NotEmpty
	@Size(max = 512)
    private String notifyUrl;

    /**
     * 状态
     */
	@NotEmpty
	@Size(max = 32)
    private String notifyStatus;

    /**
     * 备注
     */
	@Size(max = 128)
    private String comments;

    /**
     * 所属运营商id
     */
	@Size(max = 32)
    private String partnerId;

}
