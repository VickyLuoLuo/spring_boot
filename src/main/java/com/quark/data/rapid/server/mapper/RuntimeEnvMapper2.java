package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.vo.WorkflowEnvVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RuntimeEnvMapper2 {

    List<WorkflowEnvVO> getRuntimeEnvByWorkflowId(@Param("workflowId") Long workflowId);
}
