package com.zhao.erdreact.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhao.erdreact.entity.ErdData;
import com.zhao.erdreact.entity.UserData;
import com.zhao.erdreact.mapper.ErdDataMapper;
import com.zhao.erdreact.service.IErdDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
@Service
public class ErdDataServiceImpl extends ServiceImpl<ErdDataMapper, ErdData> implements IErdDataService {

    @Resource
    UserDataServiceImpl userDataService;


    public void saveErd(String user, String data) {
        ErdData erdData = new ErdData();
        UserData userData = new UserData();
        String dataId = IdUtil.simpleUUID();
        erdData.setDataId(dataId);
        erdData.setData(data);
        save(erdData);
        userData.setDataId(dataId);
        userData.setUserId(user);
        userDataService.save(userData);
    }

}
