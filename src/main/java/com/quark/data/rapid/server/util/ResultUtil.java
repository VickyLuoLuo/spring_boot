package com.quark.data.rapid.server.util;

import org.springframework.http.HttpStatus;

import com.alibaba.druid.util.StringUtils;

public class ResultUtil {

	public static ResponseBody getResponse(Integer code, Object responseBody, String responseMsg) {
		return new ResponseBody(code, responseBody, responseMsg);
	}

	public static ResponseBody getSuccessResponse() {
		return new ResponseBody(HttpStatus.OK.value(), null, null);
	}

	public static ResponseBody getSuccessResponse(Object responseBody) {
		return new ResponseBody(HttpStatus.OK.value(), responseBody, null);
	}

	public static ResponseBody getSuccessResponse(Object responseBody, String successMsg) {
		return new ResponseBody(HttpStatus.OK.value(), responseBody, successMsg);
	}

	public static ResponseBody getSuccessResponse(String successMsg) {
		return new ResponseBody(HttpStatus.OK.value(), null, successMsg);
	}

	public static ResponseBody getErrorResponse() {
		return new ResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, null);
	}

	public static ResponseBody getErrorResponse(String responseMsg) {
		if (StringUtils.isEmpty(responseMsg)) {
			responseMsg = "系统异常,请联系管理员";
		}
		return new ResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, responseMsg);
	}

}
