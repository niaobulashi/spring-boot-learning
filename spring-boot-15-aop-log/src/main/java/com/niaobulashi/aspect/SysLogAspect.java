package com.niaobulashi.aspect;

import com.niaobulashi.anno.SysLog;
import com.niaobulashi.entity.SysLogEntity;
import com.niaobulashi.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: spring-boot-learning
 * @description: 系统日志切面
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-03 23:54
 */
@Aspect //使用@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.niaobulashi.anno.SysLog)")
    public void logPointCut() {

    }

    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 保存日志
     * @param joinPoint
     * @param time
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {

        // 获取方法的关键信息，类，包
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLogEntity sysLogEntity = new SysLogEntity();
        sysLogEntity.setExeuTime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sysLogEntity.setCreateDate(dateFormat.format(new Date()));
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if(sysLog != null) {
            //注解上的描述
            sysLogEntity.setRemark(sysLog.value());
        }
        //请求的 类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogEntity.setClassName(className);
        sysLogEntity.setMethodName(methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(o.toString());
            }
            sysLogEntity.setParams(list.toString());
        } catch (Exception e){

        }
        sysLogService.save(sysLogEntity);
    }
}
