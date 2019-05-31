package com.beyondli.repository;

import org.apache.ibatis.annotations.Select;

/**
 * Created by beyondLi
 * Date 2019/5/21 14:57
 * Desc .
 */

public interface TokenQueryMapper {
    @Select("select id from user_info where age = #{value}")
    Integer tokenVerify(int i);
}
