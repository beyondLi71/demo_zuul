package com.beyondli.service;

/**
 * Created by beyondLi
 * Date 2019/5/21 14:56
 * Desc .
 */
public interface TokenService {
    //通过token查询是否失效
    void tokenVerify(int i);
}
