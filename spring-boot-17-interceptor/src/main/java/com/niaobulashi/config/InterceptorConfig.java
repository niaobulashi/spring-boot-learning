package com.niaobulashi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: spring-boot-learning
 * @description: 配置拦截器
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-06 16:36
 */
@Slf4j
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 拦截器注册类
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
    }

    /**
     * 定义拦截器
     */
    public class LogInterceptor implements HandlerInterceptor {
        long start = System.currentTimeMillis();

        /**
         * 请求执行前执行
         */
        @Override
        public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            log.info("preHandle");
            start = System.currentTimeMillis();
            return true;
        }

        /**
         * 请求结束执行
         */
        @Override
        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
            log.info("Interceptor cost="+(System.currentTimeMillis()-start));
        }

        /**
         * 视图渲染完成后执行
         */
        @Override
        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
            log.info("afterCompletion");
        }
    }
}
