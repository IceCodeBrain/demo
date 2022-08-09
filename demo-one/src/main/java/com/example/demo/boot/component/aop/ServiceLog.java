package com.example.demo.boot.component.aop;


import com.example.demo.boot.uitls.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 使用 aop 切面记录请求日志信息
 * </p>
 *
 * @description: 使用 aop 切面记录请求日志信息
 */
@Aspect
@Component
@Slf4j
public class ServiceLog {

    /**
     * 切入点
     */
    @Pointcut("execution(public *  com.example.demo.service.impl.*ServiceImpl.*(..))")
    public void log() {
    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        log.info("【请求类名】：{}", point.getSignature().getDeclaringTypeName());
        log.info("【请求方法名】：{}【参数】：{}", point.getSignature().getName(), JsonUtils.toJson(point.getArgs()));
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        log.info("【耗时】：{}毫秒", System.currentTimeMillis() - start);
        //log.info("【返回值】：{}", JsonUtils.toJson(result));
        return result;
    }


}
