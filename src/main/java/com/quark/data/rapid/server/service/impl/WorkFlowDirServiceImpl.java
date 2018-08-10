package com.quark.data.rapid.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.data.rapid.server.mapper.WorkflowDirMapper;
import com.quark.data.rapid.server.mapper.WorkflowDirMapper2;
import com.quark.data.rapid.server.mapper.WorkflowMapper;
import com.quark.data.rapid.server.model.Workflow;
import com.quark.data.rapid.server.model.WorkflowDir;
import com.quark.data.rapid.server.model.WorkflowDirExample;
import com.quark.data.rapid.server.service.WorkFlowDirService;
import com.quark.data.rapid.server.util.ResponseBody;
import com.quark.data.rapid.server.util.ResultUtil;

@Service
public class WorkFlowDirServiceImpl implements WorkFlowDirService {

	@Autowired
	private WorkflowMapper workflowMapper;

	@Autowired
	private WorkflowDirMapper workflowDirMapper;

	@Autowired
	private WorkflowDirMapper2 workflowDirMapper2;

	/**
	 * 创建文件夹
	 */
	@Override
	public ResponseBody create_folder(String folderName) {
		// 检查文件夹名称是否重复
		WorkflowDirExample folderExp = new WorkflowDirExample();
		folderExp.createCriteria().andNameEqualTo(folderName);
		List<WorkflowDir> selectByExample = workflowDirMapper.selectByExample(folderExp);
		if (selectByExample.size() > 0) {
			return ResultUtil.getErrorResponse("文件夹名称不可重复！");
		}
		WorkflowDir folder = new WorkflowDir();
		folder.setParentId(0L);
		folder.setDataStreamWorkflowId(null);
		folder.setType("0");
		folder.setName(folderName);
		workflowDirMapper.insert(folder);
		return ResultUtil.getSuccessResponse(folder);
	}

	@Override
	public ResponseBody create_canvas(String canvasName, Long folderId) {
		// 检查当前文件夹下画布名称是否重复
		WorkflowDirExample folderExp = new WorkflowDirExample();
		folderExp.createCriteria().andNameEqualTo(canvasName).andParentIdEqualTo(folderId);
		List<WorkflowDir> selectByExample = workflowDirMapper.selectByExample(folderExp);
		if (selectByExample.size() > 0) {
			return ResultUtil.getErrorResponse("同一文件夹下画布名称不可重复！");
		}
		// 创建工作流
		Workflow workflow = new Workflow();
		workflow.setWorkflowName(canvasName);
		workflow.setWorkflowDesc(canvasName);
		workflow.setCreateTime(new Date());
		workflow.setUpdateTime(new Date());
		workflow.setIsDel("0");
		workflowMapper.insert(workflow);
		// 创建画布
		WorkflowDir folder = new WorkflowDir();
		folder.setParentId(folderId);
		folder.setDataStreamWorkflowId(workflow.getId());
		folder.setType("1");
		folder.setName(canvasName);
		workflowDirMapper.insert(folder);
		return ResultUtil.getSuccessResponse(folder);
	}

	@Override
	public ResponseBody get_list() {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		// 获取所有文件夹
		WorkflowDirExample folderExp = new WorkflowDirExample();
		folderExp.createCriteria().andTypeEqualTo("0");
		List<WorkflowDir> folderList = workflowDirMapper.selectByExample(folderExp);
		for (WorkflowDir folder : folderList) {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("folder", folder);
			// 获取该文件夹下画布列表并通过创建时间正序排列
			List<WorkflowDir> canvasList = workflowDirMapper2.getWorkDirListByParentId(folder.getId());
			resultMap.put("canvasList", canvasList);
			resultList.add(resultMap);
		}
		return ResultUtil.getSuccessResponse(resultList);
	}

	@Override
	public ResponseBody change_canvas_position(Long canvasId, Long folderId) {
		// 获取当前画布信息
		WorkflowDir canvas = workflowDirMapper.selectByPrimaryKey(canvasId);
		// 检查当前文件夹下画布名称是否重复
		WorkflowDirExample folderExp = new WorkflowDirExample();
		folderExp.createCriteria().andNameEqualTo(canvas.getName()).andParentIdEqualTo(folderId);
		List<WorkflowDir> selectByExample = workflowDirMapper.selectByExample(folderExp);
		if (selectByExample.size() > 0) {
			return ResultUtil.getErrorResponse("同一文件夹下画布名称不可重复！");
		}
		// 修改画布信息
		canvas.setParentId(folderId);
		workflowDirMapper.updateByPrimaryKey(canvas);
		return ResultUtil.getSuccessResponse();
	}

	@Override
	public ResponseBody delete_workflow_dir(Long dirId, Integer dirType) {
		// 获取当前画布信息
		WorkflowDir workflowDir = workflowDirMapper.selectByPrimaryKey(dirId);
		// 如果是画布 逻辑删除画布对应工作流 物理删除画布数据
		if (dirType == 1) {
			// 逻辑删除工作流
			Workflow workflow = workflowMapper.selectByPrimaryKey(workflowDir.getDataStreamWorkflowId());
			workflow.setIsDel("1");
			workflowMapper.updateByPrimaryKey(workflow);
			// 物理删除画布
			workflowDirMapper.deleteByPrimaryKey(workflowDir.getId());
		} else if (dirType == 0) {
			// 获取文件夹下所有画布
			List<WorkflowDir> canvasList = workflowDirMapper2.getWorkDirListByParentId(dirId);
			if (canvasList.size() > 0) {
				for (WorkflowDir canvas : canvasList) {
					// 逻辑删除工作流
					Workflow workflow = workflowMapper.selectByPrimaryKey(canvas.getDataStreamWorkflowId());
					workflow.setIsDel("1");
					workflowMapper.updateByPrimaryKey(workflow);
					// 物理删除画布
					workflowDirMapper.deleteByPrimaryKey(canvas.getId());
				}
			}
			// 删除文件夹
			workflowDirMapper.deleteByPrimaryKey(dirId);
		}
		return ResultUtil.getSuccessResponse();
	}
}
