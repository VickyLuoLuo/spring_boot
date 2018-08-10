package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.WorkflowNode;
import com.quark.data.rapid.server.model.WorkflowNodeExample;
import com.quark.data.rapid.server.model.WorkflowNodeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowNodeMapper {
    long countByExample(WorkflowNodeExample example);

    int deleteByExample(WorkflowNodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkflowNodeWithBLOBs record);

    int insertSelective(WorkflowNodeWithBLOBs record);

    List<WorkflowNodeWithBLOBs> selectByExampleWithBLOBs(WorkflowNodeExample example);

    List<WorkflowNode> selectByExample(WorkflowNodeExample example);

    WorkflowNodeWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkflowNodeWithBLOBs record, @Param("example") WorkflowNodeExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkflowNodeWithBLOBs record, @Param("example") WorkflowNodeExample example);

    int updateByExample(@Param("record") WorkflowNode record, @Param("example") WorkflowNodeExample example);

    int updateByPrimaryKeySelective(WorkflowNodeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WorkflowNodeWithBLOBs record);

    int updateByPrimaryKey(WorkflowNode record);

    WorkflowNodeWithBLOBs selectForUpdate(Long id);
}