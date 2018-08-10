package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.WorkflowDir;
import com.quark.data.rapid.server.model.WorkflowDirExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowDirMapper {
    long countByExample(WorkflowDirExample example);

    int deleteByExample(WorkflowDirExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkflowDir record);

    int insertSelective(WorkflowDir record);

    List<WorkflowDir> selectByExample(WorkflowDirExample example);

    WorkflowDir selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkflowDir record, @Param("example") WorkflowDirExample example);

    int updateByExample(@Param("record") WorkflowDir record, @Param("example") WorkflowDirExample example);

    int updateByPrimaryKeySelective(WorkflowDir record);

    int updateByPrimaryKey(WorkflowDir record);

    WorkflowDir selectForUpdate(Long id);
}