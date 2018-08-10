package com.quark.data.rapid.server.model.vo;

import java.util.Date;

/**
 * 页面用，工作流业务运行统计实体
 */
public class WorkflowEnvVO {

    //工作流所部署到的运行环境的名称
    private String runtimeEnvName;

    //工作流所部署到的运行环境的ip
    private String runtimeEnvIp;

    //工作流运行时id
    private Long workflowInstId;

    //工作流运行状态
    private String status;

    //工作流开始运行时间
    private Date startTime;

    public String getRuntimeEnvName() {
        return runtimeEnvName;
    }

    public void setRuntimeEnvName(String runtimeEnvName) {
        this.runtimeEnvName = runtimeEnvName;
    }

    public String getRuntimeEnvIp() {
        return runtimeEnvIp;
    }

    public Long getWorkflowInstId() {
        return workflowInstId;
    }

    public void setWorkflowInstId(Long workflowInstId) {
        this.workflowInstId = workflowInstId;
    }

    public void setRuntimeEnvIp(String runtimeEnvIp) {
        this.runtimeEnvIp = runtimeEnvIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
