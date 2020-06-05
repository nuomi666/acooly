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
 * 用户二维码 Entity
 *
 * @author mufanglin
 * Date: 2019-11-27 11:03:15
 */
@Entity
@Table(name = "member_dimension_barcode")
@Getter
@Setter
public class MembermemberDimensionBarcode extends AbstractEntity {

    /**
     * 二维码编码
     */
	@NotEmpty
	@Size(max = 64)
    private String barcodeNo;

    /**
     * 二维码名称
     */
	@NotEmpty
	@Size(max = 128)
    private String barcodeName;

    /**
     * 用户编码
     */
	@NotEmpty
	@Size(max = 64)
    private String userNo;

    /**
     * 类型
     */
	@Size(max = 16)
    private String memberType;

    /**
     * 状态
     */
	@Size(max = 32)
    private String barcodeStatus;

    /**
     * 二维码地址
     */
	@Size(max = 1024)
    private String urlPath;

    /**
     * 二维码图片地址
     */
	@Size(max = 512)
    private String imagePath;

    /**
     * 备注
     */
	@Size(max = 256)
    private String comments;

}
