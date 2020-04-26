package com.zhao.erdreact.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhao.erdreact.entity.User;
import com.zhao.erdreact.mapper.UserMapper;
import com.zhao.erdreact.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    UserMapper mapper;

    public User getUser(String username, String password) {
        return mapper.getUser(username, password);
    }
}
