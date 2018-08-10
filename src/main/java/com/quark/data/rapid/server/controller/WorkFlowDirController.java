package com.quark.data.rapid.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quark.data.rapid.server.controller.base.BaseController;
import com.quark.data.rapid.server.service.WorkFlowDirService;
import com.quark.data.rapid.server.util.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 文件夹及画布相关 Api
 * 
 * @author WangHao 2018年8月7日
 */
@RestController
@RequestMapping("/dir")
@Api(tags = { "workflow dir controller" })
public class WorkFlowDirController extends BaseController {

	@Autowired
	private WorkFlowDirService workFlowDirService;

	@RequestMapping(value = "/create_folder", method = RequestMethod.POST)
	@ApiOperation(value = "创建文件夹", notes = "创建文件夹")
	@ApiImplicitParam(name = "folderName", value = "文件夹名称", paramType = "query", dataType = "String", required = true)
	public ResponseBody create_folder(@RequestParam(value = "folderName", required = true) String folderName) {
		return workFlowDirService.create_folder(folderName);
	}

	@RequestMapping(value = "/create_canvas", method = RequestMethod.POST)
	@ApiOperation(value = "创建画布", notes = "创建画布")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "canvasName", value = "画布名称", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "folderId", value = "文件夹Id", paramType = "query", dataType = "Long", required = true) })
	public ResponseBody create_canvas(@RequestParam(value = "canvasName", required = true) String canvasName,
			@RequestParam(value = "folderId", required = true) Long folderId) {
		return workFlowDirService.create_canvas(canvasName, folderId);
	}

	@RequestMapping(value = "/get_list", method = RequestMethod.GET)
	@ApiOperation(value = "获取工作流列表", notes = "获取所有文件夹及画布")
	public ResponseBody get_list() {
		return workFlowDirService.get_list();
	}

	@RequestMapping(value = "/change_canvas_position", method = RequestMethod.POST)
	@ApiOperation(value = "修改画布位置", notes = "修改画布所在文件夹")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "canvasId", value = "画布Id", paramType = "query", dataType = "Long", required = true),
			@ApiImplicitParam(name = "folderId", value = "文件夹Id", paramType = "query", dataType = "Long", required = true) })
	public ResponseBody change_canvas_position(@RequestParam(value = "canvasId", required = true) Long canvasId,
			@RequestParam(value = "folderId", required = true) Long folderId) {
		return workFlowDirService.change_canvas_position(canvasId, folderId);
	}

	@RequestMapping(value = "/delete_workflow_dir", method = RequestMethod.POST)
	@ApiOperation(value = "删除文件夹或画布", notes = "删除文件夹或画布")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "dirId", value = "删除目录id", paramType = "query", dataType = "Long", required = true),
			@ApiImplicitParam(name = "dirType", value = "目录类型：0：文件夹1：画布", paramType = "query", dataType = "Long", required = true) })
	public ResponseBody delete_workflow_dir(@RequestParam(value = "dirId", required = true) Long dirId,
			@RequestParam(value = "dirType", required = true) Integer dirType) {
		return workFlowDirService.delete_workflow_dir(dirId, dirType);
	}
}
