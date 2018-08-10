package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.Workflow;
import com.quark.data.rapid.server.model.WorkflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowMapper {
    long countByExample(WorkflowExample example);

    int deleteByExample(WorkflowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Workflow record);

    int insertSelective(Workflow record);

    List<Workflow> selectByExample(WorkflowExample example);

    Workflow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Workflow record, @Param("example") WorkflowExample example);

    int updateByExample(@Param("record") Workflow record, @Param("example") WorkflowExample example);

    int updateByPrimaryKeySelective(Workflow record);

    int updateByPrimaryKey(Workflow record);

    Workflow selectForUpdate(Long id);
}