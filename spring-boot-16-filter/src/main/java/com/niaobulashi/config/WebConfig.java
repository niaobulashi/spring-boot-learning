package com.niaobulashi.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义注入，并支持依赖注入，组件排序
 */
@Configuration
public class WebConfig {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    /**
     * 过滤器注册类
     * @return
     */
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 初始化过滤器MyFilter
        registration.setFilter(new MyFilter());
        // 过滤应用程序中所有资源,当前应用程序根下的所有文件包括多级子目录下的所有文件，注意这里*前有“/”
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    public class MyFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("init");
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("this is MyFilter,url :" + request.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy() {
            System.out.println("destroy");
        }
    }
}
