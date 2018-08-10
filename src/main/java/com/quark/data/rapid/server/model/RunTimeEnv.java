package com.quark.data.rapid.server.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="data_stream_runtime_env")
public class RunTimeEnv implements Serializable {
    @ApiModelProperty(value = "主键自增")
    private Long id;

    @ApiModelProperty(value = "运行环境类型（0：Flink、1：Memory、2：Spark、3：other）")
    private String runtimeType;

    @ApiModelProperty(value = "运行环境名称")
    private String runtimeName;

    @ApiModelProperty(value = "运行环境ip")
    private String runtimeIp;

    @ApiModelProperty(value = "运行环境端口")
    private Integer runtimePort;

    @ApiModelProperty(value = "运行环境用户名")
    private String runtimeUsername;

    @ApiModelProperty(value = "运行环境密码")
    private String runtimePassword;

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

    public String getRuntimeType() {
        return runtimeType;
    }

    public void setRuntimeType(String runtimeType) {
        this.runtimeType = runtimeType == null ? null : runtimeType.trim();
    }

    public String getRuntimeName() {
        return runtimeName;
    }

    public void setRuntimeName(String runtimeName) {
        this.runtimeName = runtimeName == null ? null : runtimeName.trim();
    }

    public String getRuntimeIp() {
        return runtimeIp;
    }

    public void setRuntimeIp(String runtimeIp) {
        this.runtimeIp = runtimeIp == null ? null : runtimeIp.trim();
    }

    public Integer getRuntimePort() {
        return runtimePort;
    }

    public void setRuntimePort(Integer runtimePort) {
        this.runtimePort = runtimePort;
    }

    public String getRuntimeUsername() {
        return runtimeUsername;
    }

    public void setRuntimeUsername(String runtimeUsername) {
        this.runtimeUsername = runtimeUsername == null ? null : runtimeUsername.trim();
    }

    public String getRuntimePassword() {
        return runtimePassword;
    }

    public void setRuntimePassword(String runtimePassword) {
        this.runtimePassword = runtimePassword == null ? null : runtimePassword.trim();
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
        RunTimeEnv other = (RunTimeEnv) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRuntimeType() == null ? other.getRuntimeType() == null : this.getRuntimeType().equals(other.getRuntimeType()))
            && (this.getRuntimeName() == null ? other.getRuntimeName() == null : this.getRuntimeName().equals(other.getRuntimeName()))
            && (this.getRuntimeIp() == null ? other.getRuntimeIp() == null : this.getRuntimeIp().equals(other.getRuntimeIp()))
            && (this.getRuntimePort() == null ? other.getRuntimePort() == null : this.getRuntimePort().equals(other.getRuntimePort()))
            && (this.getRuntimeUsername() == null ? other.getRuntimeUsername() == null : this.getRuntimeUsername().equals(other.getRuntimeUsername()))
            && (this.getRuntimePassword() == null ? other.getRuntimePassword() == null : this.getRuntimePassword().equals(other.getRuntimePassword()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRuntimeType() == null) ? 0 : getRuntimeType().hashCode());
        result = prime * result + ((getRuntimeName() == null) ? 0 : getRuntimeName().hashCode());
        result = prime * result + ((getRuntimeIp() == null) ? 0 : getRuntimeIp().hashCode());
        result = prime * result + ((getRuntimePort() == null) ? 0 : getRuntimePort().hashCode());
        result = prime * result + ((getRuntimeUsername() == null) ? 0 : getRuntimeUsername().hashCode());
        result = prime * result + ((getRuntimePassword() == null) ? 0 : getRuntimePassword().hashCode());
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
        sb.append(", runtimeType=").append(runtimeType);
        sb.append(", runtimeName=").append(runtimeName);
        sb.append(", runtimeIp=").append(runtimeIp);
        sb.append(", runtimePort=").append(runtimePort);
        sb.append(", runtimeUsername=").append(runtimeUsername);
        sb.append(", runtimePassword=").append(runtimePassword);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}