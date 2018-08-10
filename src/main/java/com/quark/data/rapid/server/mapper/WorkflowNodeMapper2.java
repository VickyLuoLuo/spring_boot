package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.WorkflowNodeWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkflowNodeMapper2 {

    List<WorkflowNodeWithBLOBs> getSourceNode(@Param("workflowId") Long workflowId);

    List<WorkflowNodeWithBLOBs> getProcessNode(@Param("workflowId") Long workflowId);

    List<WorkflowNodeWithBLOBs> getSinkNode(@Param("workflowId") Long workflowId);

}