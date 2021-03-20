package com.example.demo.boot.component.security;


import com.yixin.review.boot.restful.RestCode;
import com.yixin.review.boot.restful.ServiceException;
import com.yixin.review.boot.uitls.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;


/**
 * kwah 公共service
 */
@Component
@Slf4j
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Value("${name}")
    public String serviceName;


    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.debug("=========preHandle  begin==========");
        log.debug("IP : {}", IPUtils.getIpAddr(request));
        log.debug("ServerName : {}", request.getServerName());
        log.debug("Port : {}", request.getServerPort());
        log.debug("ContextPath : {}", request.getContextPath());
        log.debug("ServletPath : {}", request.getServletPath());
        log.debug("QueryString : {}", request.getQueryString());
        log.debug("serviceName ：{}", serviceName);
        log.debug("=========preHandle    end==========");

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                log.info("instor  name:{} ,value:{}", name, values);
            }
        }
        // 如果不是映射到方法直接通过
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有UnCheckToken注释，有则跳过认证
        Authority annotation = method.getAnnotation(Authority.class);
        if (annotation != null) {
            if (annotation.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new ServiceException(RestCode.UNAUTHORIZED);
        }
        log.info("token = {}", token);
        // 执行认证


        return true;


    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//		HandlerMethod h = (HandlerMethod) handler;
//		LOGGER.debug("=========afterCompletion  begin==========");
//		LOGGER.debug("Contreoller : " + h.getBean().getClass().getName());
//		LOGGER.debug("MethodName : " + h.getMethod().getName());
//		LOGGER.debug("=========afterCompletion    end==========\n\n");
    }


}
