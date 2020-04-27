package com.zhao.erdreact.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhao.erdreact.entity.ErdData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
public interface ErdDataMapper extends BaseMapper<ErdData> {

    @Update("update erd_data set data=#{data} where data_id=#{dataId}")
    void updateErd(@Param("dataId") String dataId, @Param("data") String data);
}
