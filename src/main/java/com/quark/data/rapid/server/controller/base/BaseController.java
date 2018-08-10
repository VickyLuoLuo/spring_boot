package com.quark.data.rapid.server.controller.base;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {

	private static ObjectMapper mapper = null;

	public synchronized static ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}

}
