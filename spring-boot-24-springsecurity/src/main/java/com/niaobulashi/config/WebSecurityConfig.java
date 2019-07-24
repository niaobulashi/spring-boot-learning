package com.niaobulashi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: spring-boot-learning
 * @description: Security配置器
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-24 19:23
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        System.out.println("进入配置");
//        httpSecurity.formLogin()    //表单方式
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()    //授权配置
                .anyRequest()   //所有请求
                .authenticated();   //都需要认证
    }

}

