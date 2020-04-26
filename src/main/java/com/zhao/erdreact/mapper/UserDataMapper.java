package com.zhao.erdreact.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhao.erdreact.entity.ErdData;
import com.zhao.erdreact.entity.UserData;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
public interface UserDataMapper extends BaseMapper<UserData> {


    List<ErdData> listErd(String userId);
}
