package com.niaobulashi.anno;

import java.lang.annotation.*;

/**
 * @program: spring-boot-learning
 * @description: 定义系统日志注解
 * @author: https://niaobulashi.com
 * @create: 2019-07-03 23:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
