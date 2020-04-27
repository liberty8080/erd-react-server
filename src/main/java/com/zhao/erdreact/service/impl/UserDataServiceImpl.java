package com.zhao.erdreact.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhao.erdreact.entity.ErdData;
import com.zhao.erdreact.entity.UserData;
import com.zhao.erdreact.mapper.UserDataMapper;
import com.zhao.erdreact.service.IUserDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserDataMapper, UserData> implements IUserDataService {

    @Resource
    UserDataMapper mapper;

    public List<ErdData> listErd(String userId) {
        return mapper.listErd(userId);
    }

    public void removeErd(String dataId){
        mapper.removeErd(dataId);
    }
}
