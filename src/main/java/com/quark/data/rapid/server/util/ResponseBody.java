package com.quark.data.rapid.server.util;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "自定义返回格式")
public class ResponseBody implements Serializable {

	private static final long serialVersionUID = 8641946526457559598L;

	@ApiModelProperty(value = "返回Http状态")
	private Integer code;
	@ApiModelProperty(value = "返回内容")
	private Object responseBody;
	@ApiModelProperty(value = "返回信息")
	private String responseMsg;

	public ResponseBody(Integer code, Object responseBody, String responseMsg) {
		this.code = code;
		this.responseBody = responseBody;
		this.responseMsg = responseMsg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

}
