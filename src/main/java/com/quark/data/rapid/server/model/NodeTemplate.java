package com.quark.data.rapid.server.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="data_stream_node_template")
public class NodeTemplate implements Serializable {
    @ApiModelProperty(value = "主键自增")
    private Long id;

    @ApiModelProperty(value = "节点类型（0：Source、1：Processor、2：Sink）")
    private String nodeType;

    @ApiModelProperty(value = "所属类型（0：通用节点、1：租户定制节点）")
    private String belongType;

    @ApiModelProperty(value = "节点模板名称")
    private String nodeTemplateName;

    @ApiModelProperty(value = "节点实现 jar存放路径")
    private String jarPath;

    @ApiModelProperty(value = "节点实现全类名")
    private String classname;

    @ApiModelProperty(value = "")
    private String iconPath;

    @ApiModelProperty(value = "节点模板配置json元数据（供页面动态生成使用）")
    private String jsonMetadata;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }

    public String getBelongType() {
        return belongType;
    }

    public void setBelongType(String belongType) {
        this.belongType = belongType == null ? null : belongType.trim();
    }

    public String getNodeTemplateName() {
        return nodeTemplateName;
    }

    public void setNodeTemplateName(String nodeTemplateName) {
        this.nodeTemplateName = nodeTemplateName == null ? null : nodeTemplateName.trim();
    }

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath == null ? null : jarPath.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath == null ? null : iconPath.trim();
    }

    public String getJsonMetadata() {
        return jsonMetadata;
    }

    public void setJsonMetadata(String jsonMetadata) {
        this.jsonMetadata = jsonMetadata == null ? null : jsonMetadata.trim();
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
        NodeTemplate other = (NodeTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNodeType() == null ? other.getNodeType() == null : this.getNodeType().equals(other.getNodeType()))
            && (this.getBelongType() == null ? other.getBelongType() == null : this.getBelongType().equals(other.getBelongType()))
            && (this.getNodeTemplateName() == null ? other.getNodeTemplateName() == null : this.getNodeTemplateName().equals(other.getNodeTemplateName()))
            && (this.getJarPath() == null ? other.getJarPath() == null : this.getJarPath().equals(other.getJarPath()))
            && (this.getClassname() == null ? other.getClassname() == null : this.getClassname().equals(other.getClassname()))
            && (this.getIconPath() == null ? other.getIconPath() == null : this.getIconPath().equals(other.getIconPath()))
            && (this.getJsonMetadata() == null ? other.getJsonMetadata() == null : this.getJsonMetadata().equals(other.getJsonMetadata()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNodeType() == null) ? 0 : getNodeType().hashCode());
        result = prime * result + ((getBelongType() == null) ? 0 : getBelongType().hashCode());
        result = prime * result + ((getNodeTemplateName() == null) ? 0 : getNodeTemplateName().hashCode());
        result = prime * result + ((getJarPath() == null) ? 0 : getJarPath().hashCode());
        result = prime * result + ((getClassname() == null) ? 0 : getClassname().hashCode());
        result = prime * result + ((getIconPath() == null) ? 0 : getIconPath().hashCode());
        result = prime * result + ((getJsonMetadata() == null) ? 0 : getJsonMetadata().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nodeType=").append(nodeType);
        sb.append(", belongType=").append(belongType);
        sb.append(", nodeTemplateName=").append(nodeTemplateName);
        sb.append(", jarPath=").append(jarPath);
        sb.append(", classname=").append(classname);
        sb.append(", iconPath=").append(iconPath);
        sb.append(", jsonMetadata=").append(jsonMetadata);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}