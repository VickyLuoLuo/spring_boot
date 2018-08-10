package com.quark.data.rapid.server.mapper;

import com.quark.data.rapid.server.model.NodeTemplate;
import com.quark.data.rapid.server.model.NodeTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NodeTemplateMapper {
    long countByExample(NodeTemplateExample example);

    int deleteByExample(NodeTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NodeTemplate record);

    int insertSelective(NodeTemplate record);

    List<NodeTemplate> selectByExampleWithBLOBs(NodeTemplateExample example);

    List<NodeTemplate> selectByExample(NodeTemplateExample example);

    NodeTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NodeTemplate record, @Param("example") NodeTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") NodeTemplate record, @Param("example") NodeTemplateExample example);

    int updateByExample(@Param("record") NodeTemplate record, @Param("example") NodeTemplateExample example);

    int updateByPrimaryKeySelective(NodeTemplate record);

    int updateByPrimaryKeyWithBLOBs(NodeTemplate record);

    int updateByPrimaryKey(NodeTemplate record);

    NodeTemplate selectForUpdate(Long id);
}