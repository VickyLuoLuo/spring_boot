package com.quark.data.rapid.server.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="data_stream_workflow_node")
public class WorkflowNodeWithBLOBs extends WorkflowNode implements Serializable {
    @ApiModelProperty(value = "节点属性json")
    private String workflowNodeJsonValue;

    @ApiModelProperty(value = "节点元数据json")
    private String workflowNodeJsonMetadata;

    private static final long serialVersionUID = 1L;

    public String getWorkflowNodeJsonValue() {
        return workflowNodeJsonValue;
    }

    public void setWorkflowNodeJsonValue(String workflowNodeJsonValue) {
        this.workflowNodeJsonValue = workflowNodeJsonValue == null ? null : workflowNodeJsonValue.trim();
    }

    public String getWorkflowNodeJsonMetadata() {
        return workflowNodeJsonMetadata;
    }

    public void setWorkflowNodeJsonMetadata(String workflowNodeJsonMetadata) {
        this.workflowNodeJsonMetadata = workflowNodeJsonMetadata == null ? null : workflowNodeJsonMetadata.trim();
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
        WorkflowNodeWithBLOBs other = (WorkflowNodeWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDataStreamWorkflowId() == null ? other.getDataStreamWorkflowId() == null : this.getDataStreamWorkflowId().equals(other.getDataStreamWorkflowId()))
            && (this.getDataStreamNodeTemplateId() == null ? other.getDataStreamNodeTemplateId() == null : this.getDataStreamNodeTemplateId().equals(other.getDataStreamNodeTemplateId()))
            && (this.getWorkflowNodeName() == null ? other.getWorkflowNodeName() == null : this.getWorkflowNodeName().equals(other.getWorkflowNodeName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getWorkflowNodeJsonValue() == null ? other.getWorkflowNodeJsonValue() == null : this.getWorkflowNodeJsonValue().equals(other.getWorkflowNodeJsonValue()))
            && (this.getWorkflowNodeJsonMetadata() == null ? other.getWorkflowNodeJsonMetadata() == null : this.getWorkflowNodeJsonMetadata().equals(other.getWorkflowNodeJsonMetadata()));
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
        result = prime * result + ((getWorkflowNodeJsonValue() == null) ? 0 : getWorkflowNodeJsonValue().hashCode());
        result = prime * result + ((getWorkflowNodeJsonMetadata() == null) ? 0 : getWorkflowNodeJsonMetadata().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workflowNodeJsonValue=").append(workflowNodeJsonValue);
        sb.append(", workflowNodeJsonMetadata=").append(workflowNodeJsonMetadata);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}