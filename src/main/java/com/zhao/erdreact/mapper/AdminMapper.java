package com.zhao.erdreact.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhao.erdreact.entity.Admin;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("select * from admin where `name`=#{name} and `password` = #{password}")
    Admin getAdmin(String name, String password);


}
