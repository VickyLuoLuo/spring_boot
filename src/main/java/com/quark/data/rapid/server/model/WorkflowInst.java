package com.quark.data.rapid.server.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="data_stream_workflow_inst")
public class WorkflowInst implements Serializable {
    @ApiModelProperty(value = "主键自增")
    private Long id;

    @ApiModelProperty(value = "数据流工作流id")
    private Long dataStreamWorkflowId;

    @ApiModelProperty(value = "运行环境id")
    private Long runtimeEnvId;

    @ApiModelProperty(value = "运行时名称")
    private String workflowInstName;

    @ApiModelProperty(value = "作业开始时间")
    private Date startTime;

    @ApiModelProperty(value = "作业结束时间")
    private Date endTime;

    @ApiModelProperty(value = "工作流状态（0：运行中、1：已结束、2：取消中、3：已取消、4：已失败）")
    private String status;

    @ApiModelProperty(value = "运行环境作业id，用来获取作业状态")
    private String runtimeJobId;

    @ApiModelProperty(value = "任务总数")
    private Integer total;

    @ApiModelProperty(value = "任务已创建数")
    private Integer created;

    @ApiModelProperty(value = "任务已调度数")
    private Integer scheduled;

    @ApiModelProperty(value = "任务部署中数")
    private Integer deploying;

    @ApiModelProperty(value = "任务运行中数")
    private Integer running;

    @ApiModelProperty(value = "任务已结束数")
    private Integer finished;

    @ApiModelProperty(value = "任务取消中数")
    private Integer canceling;

    @ApiModelProperty(value = "任务已取消数")
    private Integer canceled;

    @ApiModelProperty(value = "任务失败数")
    private Integer failed;

    @ApiModelProperty(value = "")
    private Integer reconciling;

    @ApiModelProperty(value = "作业运行时长（单位：秒）")
    private Long duration;

    @ApiModelProperty(value = "是否删除（0：否、1：是）")
    private String isDel;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "运行时json配置（供任务重启使用）")
    private String runtimeJson;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDataStreamWorkflowId() {
        return dataStreamWorkflowId;
    }

    public void setDataStreamWorkflowId(Long dataStreamWorkflowId) {
        this.dataStreamWorkflowId = dataStreamWorkflowId;
    }

    public Long getRuntimeEnvId() {
        return runtimeEnvId;
    }

    public void setRuntimeEnvId(Long runtimeEnvId) {
        this.runtimeEnvId = runtimeEnvId;
    }

    public String getWorkflowInstName() {
        return workflowInstName;
    }

    public void setWorkflowInstName(String workflowInstName) {
        this.workflowInstName = workflowInstName == null ? null : workflowInstName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRuntimeJobId() {
        return runtimeJobId;
    }

    public void setRuntimeJobId(String runtimeJobId) {
        this.runtimeJobId = runtimeJobId == null ? null : runtimeJobId.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getScheduled() {
        return scheduled;
    }

    public void setScheduled(Integer scheduled) {
        this.scheduled = scheduled;
    }

    public Integer getDeploying() {
        return deploying;
    }

    public void setDeploying(Integer deploying) {
        this.deploying = deploying;
    }

    public Integer getRunning() {
        return running;
    }

    public void setRunning(Integer running) {
        this.running = running;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public Integer getCanceling() {
        return canceling;
    }

    public void setCanceling(Integer canceling) {
        this.canceling = canceling;
    }

    public Integer getCanceled() {
        return canceled;
    }

    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public Integer getReconciling() {
        return reconciling;
    }

    public void setReconciling(Integer reconciling) {
        this.reconciling = reconciling;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRuntimeJson() {
        return runtimeJson;
    }

    public void setRuntimeJson(String runtimeJson) {
        this.runtimeJson = runtimeJson == null ? null : runtimeJson.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WorkflowInst other = (WorkflowInst) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDataStreamWorkflowId() == null ? other.getDataStreamWorkflowId() == null : this.getDataStreamWorkflowId().equals(other.getDataStreamWorkflowId()))
            && (this.getRuntimeEnvId() == null ? other.getRuntimeEnvId() == null : this.getRuntimeEnvId().equals(other.getRuntimeEnvId()))
            && (this.getWorkflowInstName() == null ? other.getWorkflowInstName() == null : this.getWorkflowInstName().equals(other.getWorkflowInstName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRuntimeJobId() == null ? other.getRuntimeJobId() == null : this.getRuntimeJobId().equals(other.getRuntimeJobId()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getScheduled() == null ? other.getScheduled() == null : this.getScheduled().equals(other.getScheduled()))
            && (this.getDeploying() == null ? other.getDeploying() == null : this.getDeploying().equals(other.getDeploying()))
            && (this.getRunning() == null ? other.getRunning() == null : this.getRunning().equals(other.getRunning()))
            && (this.getFinished() == null ? other.getFinished() == null : this.getFinished().equals(other.getFinished()))
            && (this.getCanceling() == null ? other.getCanceling() == null : this.getCanceling().equals(other.getCanceling()))
            && (this.getCanceled() == null ? other.getCanceled() == null : this.getCanceled().equals(other.getCanceled()))
            && (this.getFailed() == null ? other.getFailed() == null : this.getFailed().equals(other.getFailed()))
            && (this.getReconciling() == null ? other.getReconciling() == null : this.getReconciling().equals(other.getReconciling()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRuntimeJson() == null ? other.getRuntimeJson() == null : this.getRuntimeJson().equals(other.getRuntimeJson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataStreamWorkflowId() == null) ? 0 : getDataStreamWorkflowId().hashCode());
        result = prime * result + ((getRuntimeEnvId() == null) ? 0 : getRuntimeEnvId().hashCode());
        result = prime * result + ((getWorkflowInstName() == null) ? 0 : getWorkflowInstName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRuntimeJobId() == null) ? 0 : getRuntimeJobId().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getScheduled() == null) ? 0 : getScheduled().hashCode());
        result = prime * result + ((getDeploying() == null) ? 0 : getDeploying().hashCode());
        result = prime * result + ((getRunning() == null) ? 0 : getRunning().hashCode());
        result = prime * result + ((getFinished() == null) ? 0 : getFinished().hashCode());
        result = prime * result + ((getCanceling() == null) ? 0 : getCanceling().hashCode());
        result = prime * result + ((getCanceled() == null) ? 0 : getCanceled().hashCode());
        result = prime * result + ((getFailed() == null) ? 0 : getFailed().hashCode());
        result = prime * result + ((getReconciling() == null) ? 0 : getReconciling().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRuntimeJson() == null) ? 0 : getRuntimeJson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dataStreamWorkflowId=").append(dataStreamWorkflowId);
        sb.append(", runtimeEnvId=").append(runtimeEnvId);
        sb.append(", workflowInstName=").append(workflowInstName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", runtimeJobId=").append(runtimeJobId);
        sb.append(", total=").append(total);
        sb.append(", created=").append(created);
        sb.append(", scheduled=").append(scheduled);
        sb.append(", deploying=").append(deploying);
        sb.append(", running=").append(running);
        sb.append(", finished=").append(finished);
        sb.append(", canceling=").append(canceling);
        sb.append(", canceled=").append(canceled);
        sb.append(", failed=").append(failed);
        sb.append(", reconciling=").append(reconciling);
        sb.append(", duration=").append(duration);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", runtimeJson=").append(runtimeJson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}