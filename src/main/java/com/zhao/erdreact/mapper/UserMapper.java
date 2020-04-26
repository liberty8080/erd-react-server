package com.zhao.erdreact.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhao.erdreact.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name = #{name} and password = #{password}")
    User getUser(String name, String password);
}
