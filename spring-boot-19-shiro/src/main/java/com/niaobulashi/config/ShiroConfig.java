package com.niaobulashi.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: spring-boot-learning
 * @description: Shiro配置
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-09 21:21
 */
@Slf4j
@Configuration
public class ShiroConfig {

    /**
     * 初始化ShiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/notLogin");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        // 设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接，顺序判断。游客，开放权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        // 用户，需要角色权限"user"
        filterChainDefinitionMap.put("/user/**", "roles[user]");
        // 管理员，需要角色权限"admin"
        filterChainDefinitionMap.put("/admin/**","roles[admin]");
        // 开放登陆接口
        filterChainDefinitionMap.put("/login", "anon");
        // 其余接口一律拦截，一般将/**放在最为下边
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        log.info("Shiro拦截器工厂类注入成功");

        return shiroFilterFactoryBean;
    }

    /**
     * 注入SecurityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setRealm(customRealm);
        return securityManager;
    }
}
