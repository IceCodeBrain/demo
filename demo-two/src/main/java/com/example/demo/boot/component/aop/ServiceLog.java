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
 * @package: com.xkcoding.log.aop.aspectj
 * @description: 使用 aop 切面记录请求日志信息
 * @author: yangkai.shen
 * @date: Created in 2018/10/1 10:05 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Aspect
@Component
@Slf4j
public class ServiceLog {
    private static final String START_TIME = "request-start";

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.example.demo.service.*ServiceImpl.*(..))")
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
        log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
        log.info("【请求参数】：{}，", JsonUtils.toJson(point.getArgs()));
        Long start = System.currentTimeMillis();
        Object result = point.proceed();
        Long end = System.currentTimeMillis();
        log.info("【耗时】：{}毫秒", end - start);
        log.info("【返回值】：{}", JsonUtils.toJson(result));
        return result;
    }


}
