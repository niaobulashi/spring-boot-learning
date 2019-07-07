package com.niaobulashi.entity;

import lombok.Data;

/**
 * @program: spring-boot-learning
 * @description: 系统日志
 * @author: https://niaobulashi.com
 * @create: 2019-07-03 23:51
 */
@Data
public class SysLogEntity {
    private String className;

    private String methodName;

    private String params;

    private Long exeuTime;

    private String remark;

    private String createDate;
}
