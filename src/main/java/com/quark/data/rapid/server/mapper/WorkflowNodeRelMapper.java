package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.WorkflowNodeRel;
import com.quark.data.rapid.server.model.WorkflowNodeRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowNodeRelMapper {
    long countByExample(WorkflowNodeRelExample example);

    int deleteByExample(WorkflowNodeRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkflowNodeRel record);

    int insertSelective(WorkflowNodeRel record);

    List<WorkflowNodeRel> selectByExample(WorkflowNodeRelExample example);

    WorkflowNodeRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkflowNodeRel record, @Param("example") WorkflowNodeRelExample example);

    int updateByExample(@Param("record") WorkflowNodeRel record, @Param("example") WorkflowNodeRelExample example);

    int updateByPrimaryKeySelective(WorkflowNodeRel record);

    int updateByPrimaryKey(WorkflowNodeRel record);

    WorkflowNodeRel selectForUpdate(Long id);
}