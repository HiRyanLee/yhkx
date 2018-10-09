package com.yhkx.restapi.filter;

import com.xmair.core.util.ApiLogger;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LiSs
 * @date on 2018/7/8
 */
public class CommonFilterOne implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApiLogger.info("CommonFilterOne init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ApiLogger.info("CommonFilterOne filter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
