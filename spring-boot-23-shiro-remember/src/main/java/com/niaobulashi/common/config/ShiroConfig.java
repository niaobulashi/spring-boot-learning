package com.niaobulashi.common.config;

import com.niaobulashi.common.realm.AuthRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

	/**
	 * 路径过滤规则
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 拦截器
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		// 配置不会被拦截的链接 顺序判断
		// 对静态资源设置匿名访问
		map.put("/static/**", "anon");
		map.put("/css/**", "anon");
		map.put("/js/**", "anon");
		map.put("/captcha/captchaImage**", "anon");
		// 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
		// 进行身份认证后才能访问
		// authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
		// user指的是用户认证通过或者配置了Remember Me记住用户登录状态后可访问
		map.put("/**", "user");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}

	/**
	 * 自定义身份认证Realm（包含用户名密码校验，权限校验等）
	 * @return
	 */
	@Bean
	public AuthRealm authRealm() {
		return new AuthRealm();
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm
		securityManager.setRealm(authRealm());
		// 用户授权/认证信息Cache, 采用EhC//注入记住我管理器
		securityManager.setRememberMeManager(rememberMeManager());
		return securityManager;
	}

	/**
	 * 开启Shiro注解模式，可以在Controller中的方法上添加注解
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * cookie对象
	 * @return
	 */
	public SimpleCookie rememberMeCookie() {
		// 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		// 设置cookie的过期时间，单位为秒，这里为一天
		cookie.setMaxAge(86400);
		return cookie;
	}

	/**
	 * cookie管理对象
	 * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
	 * @return
	 */
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		// rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
		cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
		return cookieRememberMeManager;
	}
}