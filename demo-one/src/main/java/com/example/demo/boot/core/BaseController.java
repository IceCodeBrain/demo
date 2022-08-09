package com.example.demo.boot.core;

import com.example.demo.boot.component.security.JWTUtils;
import com.example.demo.boot.restful.CommonException;
import com.example.demo.boot.restful.RestCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: BaseController <br>
 * @date: 2020/1/10 14:33 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Slf4j
public class BaseController {


    public Integer getUserId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new CommonException(RestCode.UNAUTHORIZED);
        }
        HttpServletRequest request = requestAttributes.getRequest();
        return Integer.parseInt(getUserId(request));
    }


    public String getUserId(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        token = JWTUtils.getUserId(token);
        if (StringUtils.isEmpty(token)) {
            throw new CommonException(RestCode.UNAUTHORIZED);
        }
        return token;
    }

    public Long getUserIdL() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new CommonException(RestCode.UNAUTHORIZED);
        }
        HttpServletRequest request = requestAttributes.getRequest();
        return Long.parseLong(getUserId(request));
    }

}
