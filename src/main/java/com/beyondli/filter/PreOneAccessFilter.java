package com.beyondli.filter;

import com.beyondli.service.TokenService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2019/5/21 14:43
 * Desc .
 */
@Component
public class PreOneAccessFilter extends ZuulFilter {
    @Resource
    TokenService tokenService;

    //决定过滤器在哪个生命周期执行
    @Override
    public String filterType() {
        return "pre";
    }
    //过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }
    //过滤的范围
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //实际业务
    @Override
    public Object run() throws ZuulException {
        System.out.println("================gw one test=================");
        /*
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getParameter("accessTokmken");
        */
        tokenService.tokenVerify(18);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("user_id", "123321");
        return null;
    }
}
