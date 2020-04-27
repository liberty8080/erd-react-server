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

    @Resource
    ErdDataMapper dataMapper;


    public void saveErd(String userId, String data,String desc,
                        String name,String dataId) {
        ErdData erdData = new ErdData();
        UserData userData = new UserData();
//        String dataId = IdUtil.simpleUUID();
        erdData.setDataId(dataId);
        erdData.setData(data);
        erdData.setDataDesc(desc);
        erdData.setDataName(name);
        save(erdData);
        userData.setDataId(dataId);
        userData.setUserId(userId);
        userDataService.save(userData);
    }

    public void updateErd(String dataId,String data){
        dataMapper.updateErd(dataId,data);
    }

}
