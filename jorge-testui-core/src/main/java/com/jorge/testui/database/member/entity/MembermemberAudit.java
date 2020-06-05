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
 * 会员审核表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:15
 */
@Entity
@Table(name = "member_audit")
@Getter
@Setter
public class MembermemberAudit extends AbstractEntity {

    /**
     * 业务号
     */
	@NotEmpty
	@Size(max = 64)
    private String businessNo;

    /**
     * 业务类型:
     */
	@NotEmpty
	@Size(max = 32)
    private String businessType;

    /**
     * 审核类型
     */
	@NotEmpty
	@Size(max = 32)
    private String auditType;

    /**
     * 状态:
     */
	@NotEmpty
	@Size(max = 32)
    private String auditStatus;

    /**
     * 审核人员ID
     */
	@NotNull
    private Long auditUserId;

    /**
     * 审核人员电话号码
     */
	@NotEmpty
	@Size(max = 11)
    private String auditMobileNo;

    /**
     * 审核人员真实姓名
     */
	@NotEmpty
	@Size(max = 32)
    private String auditRealName;

    /**
     * 审核人员意见
     */
	@NotEmpty
	@Size(max = 255)
    private String auditOpinion;

}
