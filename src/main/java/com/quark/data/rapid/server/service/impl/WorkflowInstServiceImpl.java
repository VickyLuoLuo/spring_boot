package com.quark.data.rapid.server.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.data.rapid.server.mapper.RunTimeEnvMapper;
import com.quark.data.rapid.server.mapper.WorkflowInstMapper;
import com.quark.data.rapid.server.model.RunTimeEnv;
import com.quark.data.rapid.server.model.RunTimeEnvExample;
import com.quark.data.rapid.server.model.WorkflowInst;
import com.quark.data.rapid.server.model.WorkflowInstExample;
import com.quark.data.rapid.server.model.enums.RuntimeState;
import com.quark.data.rapid.server.service.WorkflowInstService;
import com.quark.data.rapid.server.util.PropertiesUtil;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@Service
public class WorkflowInstServiceImpl implements WorkflowInstService {

	@Autowired
	private WorkflowInstMapper workflowInstMapper;

	@Autowired
	private RunTimeEnvMapper runTimeEnvMapper;

	@Autowired
	private PropertiesUtil propertiesUtil;

	@Override
	public void deploy_workflow(Long gatewayId, Long workflowId, String jobId, String jobName, String state,
			String workflow_json) {
		// 保存基本运行记录
		WorkflowInst workflowIns = new WorkflowInst();
		workflowIns.setDataStreamWorkflowId(workflowId);
		workflowIns.setRuntimeEnvId(gatewayId);
		workflowIns.setWorkflowInstName(jobName);
		workflowIns.setStartTime(new Date());
		workflowIns.setRuntimeJson(workflow_json);
		workflowIns.setRuntimeJobId(jobId);
		workflowIns.setStatus(RuntimeState.getKeyByValue(state));
		workflowIns.setIsDel("0");
		workflowIns.setCreateTime(new Date());
		workflowIns.setUpdateTime(new Date());
		workflowInstMapper.insert(workflowIns);
	}

	/**
	 * 每十秒获取一次所有的服务器或网关 更新对应的任务状态
	 */
	@PostConstruct
	public void execution() {
		CronUtil.schedule("*/50 * * * * *", new Task() {
			@Override
			public void execute() {
				updateWorkflowInst();
			}
		});
		// 支持秒级别定时任务
		CronUtil.setMatchSecond(true);
		CronUtil.start();
	}

	/**
	 * 更新数据库工作流运行状态
	 * 
	 * @param
	 */
	private void updateWorkflowInst() {
		// 获取所有服务器或网关
		List<RunTimeEnv> runTimeEnvList = runTimeEnvMapper.selectByExample(new RunTimeEnvExample());
		Map<String, Object> paramMap = null;
		for (RunTimeEnv runTimeEnv : runTimeEnvList) {
			// 通过网关设置 获取该网关下所有的信息
			switch (runTimeEnv.getRuntimeType()) {
			case "0":// Flink
				String flinkTopologUrl = propertiesUtil.getTopologip() + propertiesUtil.getTopologjoblist();
				String runtimeIp = runTimeEnv.getRuntimeIp();
				Integer runtimePort = runTimeEnv.getRuntimePort();
				paramMap = new HashMap<String, Object>();
				paramMap.put("host", runtimeIp + ":" + runtimePort.toString());
				paramMap.put("engineType", "flink");
				String resultJson = HttpUtil.post(flinkTopologUrl, JSONUtil.toJsonStr(paramMap));
				JSONObject resultObj = JSONUtil.parseObj(resultJson);
				JSONArray resultList = resultObj.getJSONArray("responseBody");
				for (Object object : resultList) {
					JSONObject parseObj = JSONUtil.parseObj(object.toString());
					String jobid = parseObj.getStr("jobid");
					WorkflowInstExample workflowInstExample = new WorkflowInstExample();
					workflowInstExample.createCriteria().andRuntimeJobIdEqualTo(jobid);
					List<WorkflowInst> workflowInstList = workflowInstMapper.selectByExample(workflowInstExample);
					if (workflowInstList.size() > 0) {
						WorkflowInst workflowInst = workflowInstList.get(0);
						// 更新状态
						workflowInst.setStatus(RuntimeState.getKeyByValue(parseObj.getStr("state")));
						// 更新开始时间
						Date startDate = new Date();
						startDate.setTime(parseObj.getLong("starttime"));
						workflowInst.setStartTime(startDate);
						// 更新结束时间
						if (!(parseObj.getLong("endtime") == -1)) {
							Date endDate = new Date();
							endDate.setTime(parseObj.getLong("endtime"));
							workflowInst.setEndTime(startDate);
						}
						// 更新持续时间
						workflowInst.setDuration(parseObj.getLong("duration"));
						// 更新最后更新时间
						Date updateDate = new Date();
						updateDate.setTime(parseObj.getLong("lastmodification"));
						workflowInst.setUpdateTime(updateDate);
						// 更新统计数量
						JSONObject taskObj = parseObj.getJSONObject("tasks");
						workflowInst.setTotal(taskObj.getInt("total"));
						workflowInst.setCreated(taskObj.getInt("created"));
						workflowInst.setScheduled(taskObj.getInt("scheduled"));
						workflowInst.setDeploying(taskObj.getInt("deploying"));
						workflowInst.setRunning(taskObj.getInt("running"));
						workflowInst.setFinished(taskObj.getInt("finished"));
						workflowInst.setCanceling(taskObj.getInt("canceling"));
						workflowInst.setCanceled(taskObj.getInt("canceled"));
						workflowInst.setFailed(taskObj.getInt("failed"));
						workflowInst.setReconciling(taskObj.getInt("reconciling"));
						workflowInstMapper.updateByPrimaryKey(workflowInst);
					}
				}
				break;
			default:
				break;
			}
		}
	}
}
