package com.example.demo.boot.component.security;


import com.example.demo.boot.restful.RestCode;
import com.example.demo.boot.restful.ServiceException;
import com.example.demo.boot.uitls.IPUtils;
import com.example.demo.model.vo.AdminVO;
import com.example.demo.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * 管理员相关权限认证拦截器
 *
 * @author pwb
 * @create 2019/7/15
 * @since 1.0.0
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class AdminInterceptor implements HandlerInterceptor {

    private final AdminService adminService;


    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("【【【【【【【=========preHandle  admin 管理员权限认证 begin==========】】】】】】】");
        log.info("管理员 IP={} : 请求 path={}", IPUtils.getIP(request), request.getServletPath());
        // 如果不是映射到方法直接通过
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有Authority注释
        Authority annotation = method.getAnnotation(Authority.class);
        if (annotation != null) {
            if (!annotation.required()) {
                return true;
            }
        } else {
            annotation = handlerMethod.getBean().getClass().getAnnotation(Authority.class);
            if (annotation != null) {
                if (!annotation.required()) {
                    return true;
                }
            }
        }
        //检查有没有需要用户权限的注解
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            throw new ServiceException(RestCode.UNAUTHORIZED);
        }
        // 执行认证
        String userIdStr = JWTUtils.getUserId(token);
        if (StringUtils.isEmpty(userIdStr)) {
            throw new ServiceException(RestCode.UNAUTHORIZED);
        }
        AdminVO adminAuthVO = adminService.queryById(Integer.parseInt(userIdStr));
        if (adminAuthVO == null) {
            throw new ServiceException(RestCode.UNAUTHORIZED);
        }
        JWTUtils.verify(token, adminAuthVO.getId().toString(), adminAuthVO.getPassword());
        if (annotation == null) {
            return true;
        }
        int[] needAuth = annotation.value();
        if (needAuth.length == 0) {
            return true;
        }
        if (needAuth[0] == 0) {
            return true;
        }
        Integer type = adminAuthVO.getType();
        for (int value : needAuth) {
            if (type == value) {
                return true;
            }
        }
        throw new ServiceException(RestCode.UNAUTHORIZED);
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }


}
