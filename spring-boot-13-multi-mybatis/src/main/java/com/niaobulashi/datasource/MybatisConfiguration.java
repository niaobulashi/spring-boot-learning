package com.niaobulashi.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-13-multi-mybatis
 * @description:
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-01 20:48
 */
@Configuration
public class MybatisConfiguration {
    /**
     * 试application.yml中的mybatis.configuration配置生效，如果不主动配置，由于@Order配置顺序不同，讲导致配置不能及时生效
     * 使配置信息加载到类中，再注入到SqlSessionFactoryBean
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration configuration() {
        return new org.apache.ibatis.session.Configuration();
    }
}

