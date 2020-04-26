package com.zhao.erdreact.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhao.erdreact.entity.Admin;
import com.zhao.erdreact.mapper.AdminMapper;
import com.zhao.erdreact.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Resource
    AdminMapper mapper;

    public Admin getAdmin(String username, String passwrod) {
        return mapper.getAdmin(username, passwrod);
    }


}
