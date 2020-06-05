package com.jorge.testui.system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-04-07 22:37
 */
@Slf4j
@Getter
@Setter
public class ParameterStatusDto {
    private String projectNo ;
    private int interfaceCount;
    private int totalTestCaseCount;
    private int successCount;
    private int failCount;

}
