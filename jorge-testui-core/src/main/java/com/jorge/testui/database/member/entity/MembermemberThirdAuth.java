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
 * 会员第三方认证表 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:17
 */
@Entity
@Table(name = "member_third_auth")
@Getter
@Setter
public class MembermemberThirdAuth extends AbstractEntity {

    /**
     * 会员编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 昵称
     */
	@Size(max = 64)
    private String nickName;

    /**
     * 头像类型
     */
	@Size(max = 16)
    private String profilePhotoType;

    /**
     * 头像
     */
	@Size(max = 255)
    private String profilePhoto;

    /**
     * 第三方应用唯一标识
     */
	@NotEmpty
	@Size(max = 64)
    private String openId;

    /**
     * 第三方用户统一标识
     */
	@Size(max = 64)
    private String unionId;

    /**
     * 授权token
     */
	@Size(max = 128)
    private String token;

    /**
     * 更新token
     */
	@Size(max = 128)
    private String freshToken;

    /**
     * 登录方式
     */
	@NotEmpty
	@Size(max = 32)
    private String authType;

    /**
     * 备注
     */
	@Size(max = 128)
    private String comments;

}
