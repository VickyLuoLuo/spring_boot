package com.quark.data.rapid.server.service;

import com.quark.data.rapid.server.util.ResponseBody;

public interface RuntimeEnvService {

	/**
	 * 添加流处理运行环境
	 *
	 * @param runtimeName
	 * @param runtimeIp
	 * @param runtimePort
	 * @param runtimeUsername
	 * @param runtimePassword
	 * @return
	 */
	ResponseBody addRuntimeEnv(String runtimeName, String runtimeType, String runtimeIp, Integer runtimePort,
			String runtimeUsername, String runtimePassword);

	/**
	 * 获取所有服务器及网关列表
	 * 
	 * @author WangHao
	 * @param page
	 * @param pageSize
	 * @param sort
	 * @param sortType
	 */
	ResponseBody env_list(Integer page, Integer pageSize, Integer sort, Integer sortType);
}
