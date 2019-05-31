package com.beyondli.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by beyondLi
 * Date 2019/5/21 14:43
 * Desc .
 */
//@Component
public class OneAccessFilter extends ZuulFilter {

    //决定过滤器在哪个生命周期执行
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }
    //过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 1;
    }
    //过滤的范围
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //实际业务
    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        String requestURI = ctx.getRequest().getRequestURI();
        System.out.println(requestURI);

        ctx.put(FilterConstants.REQUEST_URI_KEY, requestURI);
        return null;
    }
}
