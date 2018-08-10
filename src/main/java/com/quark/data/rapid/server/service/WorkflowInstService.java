package com.quark.data.rapid.server.service;

public interface WorkflowInstService {

	/**
	 * 添加部署工作流
	 * 
	 * @author WangHao
	 * @param gatewayId
	 *            网关ID
	 * @param workflowId
	 *            工作流ID
	 * @param jobId
	 *            工作流ID
	 * @param jobName
	 *            任务名称
	 * @param state
	 *            任务状态
	 * @param workflow_json
	 *            部署数据
	 */
	void deploy_workflow(Long gatewayId, Long workflowId, String jobId, String jobName, String state,
			String workflow_json);

}
