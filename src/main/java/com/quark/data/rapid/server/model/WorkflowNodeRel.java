package com.quark.data.rapid.server.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="data_stream_workflow_node_rel")
public class WorkflowNodeRel implements Serializable {
    @ApiModelProperty(value = "主键自增")
    private Long id;

    @ApiModelProperty(value = "数据流工作流id")
    private Long dataStreamWorkflowId;

    @ApiModelProperty(value = "from节点id")
    private Long fromId;

    @ApiModelProperty(value = "to节点id")
    private Long toId;

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

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
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
        WorkflowNodeRel other = (WorkflowNodeRel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDataStreamWorkflowId() == null ? other.getDataStreamWorkflowId() == null : this.getDataStreamWorkflowId().equals(other.getDataStreamWorkflowId()))
            && (this.getFromId() == null ? other.getFromId() == null : this.getFromId().equals(other.getFromId()))
            && (this.getToId() == null ? other.getToId() == null : this.getToId().equals(other.getToId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataStreamWorkflowId() == null) ? 0 : getDataStreamWorkflowId().hashCode());
        result = prime * result + ((getFromId() == null) ? 0 : getFromId().hashCode());
        result = prime * result + ((getToId() == null) ? 0 : getToId().hashCode());
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
        sb.append(", fromId=").append(fromId);
        sb.append(", toId=").append(toId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}