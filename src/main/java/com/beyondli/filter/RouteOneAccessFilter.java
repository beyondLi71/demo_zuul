package com.beyondli.filter;

import com.beyondli.service.TokenService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2019/5/21 14:43
 * Desc .
 */
@Component
public class RouteOneAccessFilter extends ZuulFilter {
    @Resource
    TokenService tokenService;

    //决定过滤器在哪个生命周期执行
    @Override
    public String filterType() {
        return "route";
    }
    //过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }
    //过滤的范围
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String requestURI = ctx.getRequest().getRequestURI();
        return requestURI.contains("forward");
        //return true;
    }
    //实际业务
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String uri = (String) ctx.get(FilterConstants.REQUEST_URI_KEY);
        uri = uri.replace("errinfo","info");
        ctx.put(FilterConstants.REQUEST_URI_KEY, uri);
        return null;
    }
}
