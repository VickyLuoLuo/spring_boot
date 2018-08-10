package com.quark.data.rapid.server.mapper;

import java.util.List;

import com.quark.data.rapid.server.model.WorkflowDir;

public interface WorkflowDirMapper2 {

	List<WorkflowDir> getWorkDirListByParentId(Long id);

}
