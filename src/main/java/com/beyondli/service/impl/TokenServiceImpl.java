package com.beyondli.service.impl;

import com.beyondli.repository.TokenQueryMapper;
import com.beyondli.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2019/5/21 14:56
 * Desc .
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    TokenQueryMapper tokenQueryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void tokenVerify(int i) {
        Integer id = tokenQueryMapper.tokenVerify(i);
        System.out.println(id);
    }
}
