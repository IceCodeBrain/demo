package com.example.demo.boot.component.aop;


import com.example.demo.boot.restful.RestResult;
import com.example.demo.boot.restful.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Description
 * @Author zyf
 * @Date 2019/8/17 16:28
 */
@Aspect
@Component
@Slf4j
public class RpcAop {

    private static final int SUCCESS = 200;

    private static final int FAIL = 400;

    /*  @Pointcut("execution(public * com.example.demo.service.feign.*Feign.*(..)) "+
              "|| execution(public * com.example.demo.service.feign..*.*Feign.*(..))")*/
    @Pointcut("execution(private * com.example.demo.service.*ServiceImpl.*(..))")
    public void rpcPointcut() {
    }

    @AfterReturning(returning = "object", pointcut = "rpcPointcut()")
    public void afterReturning(JoinPoint joinPoint, Object object) {
        if (object instanceof RestResult) {
            RestResult result = (RestResult) object;
            if (result.getCode() != SUCCESS && result.getCode() != 201
                    && result.getCode() != 202
                    && result.getCode() != 203) {
                log.info("feign request error ResultObject : {}", msg(joinPoint, object));
                throw new ServiceException(result.getCode(), result.getMsg());
            }
        } else {
            log.info("feign request error : {}", msg(joinPoint, object));
            throw new ServiceException(FAIL, msg(joinPoint, object));
        }
    }

    private String msg(JoinPoint joinPoint, Object object) {
        return "method: " + joinPoint.getSignature().getName() +
                ", param: " + Arrays.toString(joinPoint.getArgs()) +
                ", return: " + (Objects.nonNull(object) ? object.toString() : "");
    }
}
