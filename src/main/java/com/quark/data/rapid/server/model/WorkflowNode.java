package com.quark.data.rapid.server.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="data_stream_workflow_node")
public class WorkflowNode implements Serializable {
    @ApiModelProperty(value = "主键自增")
    private Long id;

    @ApiModelProperty(value = "数据流工作流id")
    private Long dataStreamWorkflowId;

    @ApiModelProperty(value = "数据流节点模板id")
    private Long dataStreamNodeTemplateId;

    @ApiModelProperty(value = "数据流工作流节点名称")
    private String workflowNodeName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

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

    public Long getDataStreamNodeTemplateId() {
        return dataStreamNodeTemplateId;
    }

    public void setDataStreamNodeTemplateId(Long dataStreamNodeTemplateId) {
        this.dataStreamNodeTemplateId = dataStreamNodeTemplateId;
    }

    public String getWorkflowNodeName() {
        return workflowNodeName;
    }

    public void setWorkflowNodeName(String workflowNodeName) {
        this.workflowNodeName = workflowNodeName == null ? null : workflowNodeName.trim();
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
        WorkflowNode other = (WorkflowNode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDataStreamWorkflowId() == null ? other.getDataStreamWorkflowId() == null : this.getDataStreamWorkflowId().equals(other.getDataStreamWorkflowId()))
            && (this.getDataStreamNodeTemplateId() == null ? other.getDataStreamNodeTemplateId() == null : this.getDataStreamNodeTemplateId().equals(other.getDataStreamNodeTemplateId()))
            && (this.getWorkflowNodeName() == null ? other.getWorkflowNodeName() == null : this.getWorkflowNodeName().equals(other.getWorkflowNodeName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataStreamWorkflowId() == null) ? 0 : getDataStreamWorkflowId().hashCode());
        result = prime * result + ((getDataStreamNodeTemplateId() == null) ? 0 : getDataStreamNodeTemplateId().hashCode());
        result = prime * result + ((getWorkflowNodeName() == null) ? 0 : getWorkflowNodeName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", dataStreamNodeTemplateId=").append(dataStreamNodeTemplateId);
        sb.append(", workflowNodeName=").append(workflowNodeName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}