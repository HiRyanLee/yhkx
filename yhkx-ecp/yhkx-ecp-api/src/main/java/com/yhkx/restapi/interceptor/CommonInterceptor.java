package com.yhkx.restapi.interceptor;

import com.yhkx.core.util.ApiLogger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器示范例子
 *
 * @author LiSs
 * @date on 2018/7/8
 */
@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ApiLogger.info("CommonInterceptor demo 1 preHandle");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ApiLogger.info("CommonInterceptor demo 1 afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
