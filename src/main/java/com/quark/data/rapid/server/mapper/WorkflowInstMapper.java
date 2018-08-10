package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.WorkflowInst;
import com.quark.data.rapid.server.model.WorkflowInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowInstMapper {
    long countByExample(WorkflowInstExample example);

    int deleteByExample(WorkflowInstExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkflowInst record);

    int insertSelective(WorkflowInst record);

    List<WorkflowInst> selectByExampleWithBLOBs(WorkflowInstExample example);

    List<WorkflowInst> selectByExample(WorkflowInstExample example);

    WorkflowInst selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkflowInst record, @Param("example") WorkflowInstExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkflowInst record, @Param("example") WorkflowInstExample example);

    int updateByExample(@Param("record") WorkflowInst record, @Param("example") WorkflowInstExample example);

    int updateByPrimaryKeySelective(WorkflowInst record);

    int updateByPrimaryKeyWithBLOBs(WorkflowInst record);

    int updateByPrimaryKey(WorkflowInst record);

    WorkflowInst selectForUpdate(Long id);
}