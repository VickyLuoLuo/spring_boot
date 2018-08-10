package com.quark.data.rapid.server.service;

import com.quark.data.rapid.server.util.ResponseBody;

public interface WorkFlowDirService {

	/**
	 * 创建文件夹
	 * 
	 * @author WangHao 2018年8月7日
	 * @param folderName
	 */
	ResponseBody create_folder(String folderName);

	/**
	 * 创建画布
	 * 
	 * @author WangHao 2018年8月7日
	 * @param canvasName
	 * @param folderId
	 */
	ResponseBody create_canvas(String canvasName, Long folderId);

	/**
	 * 获取所有文件夹及工作流
	 * 
	 * @author WangHao 2018年8月7日
	 */
	ResponseBody get_list();

	/**
	 * 更爱画布所在文件夹
	 * 
	 * @author WangHao 2018年8月7日
	 * @param canvasId
	 * @param folderId
	 */
	ResponseBody change_canvas_position(Long canvasId, Long folderId);

	/**
	 * 删除文件夹或画布
	 * 
	 * @author WangHao 2018年8月7日
	 * @param dirId
	 * @param dirType
	 */
	ResponseBody delete_workflow_dir(Long dirId, Integer dirType);
}
