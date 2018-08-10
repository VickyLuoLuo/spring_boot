package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.RunTimeEnv;
import com.quark.data.rapid.server.model.RunTimeEnvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RunTimeEnvMapper {
    long countByExample(RunTimeEnvExample example);

    int deleteByExample(RunTimeEnvExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RunTimeEnv record);

    int insertSelective(RunTimeEnv record);

    List<RunTimeEnv> selectByExample(RunTimeEnvExample example);

    RunTimeEnv selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RunTimeEnv record, @Param("example") RunTimeEnvExample example);

    int updateByExample(@Param("record") RunTimeEnv record, @Param("example") RunTimeEnvExample example);

    int updateByPrimaryKeySelective(RunTimeEnv record);

    int updateByPrimaryKey(RunTimeEnv record);

    RunTimeEnv selectForUpdate(Long id);
}