package com.example.demo.boot.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description: DefineKeyGenerator <br>
 * @date: 2020/1/15 10:08 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Component
public class DefineKeyGenerator implements KeyGenerator {

    //EnhancerBySpringCGLIB  Spring CGLIB增强器
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return generateTo(method, params);
    }

    private static Object generateTo(Method method, Object... params) {
        StringBuilder sb = new StringBuilder(16);
        sb.append(method.getName());
        if (params.length == 0) {
            return sb.toString();
        }
        sb.append("->");
        for (int i = 0; i < params.length; i++) {
            sb.append(params[i]);
            if (i < params.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
