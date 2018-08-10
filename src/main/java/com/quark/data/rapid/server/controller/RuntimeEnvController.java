package com.quark.data.rapid.server.controller;

import com.quark.data.rapid.server.controller.base.BaseController;
import com.quark.data.rapid.server.service.RuntimeEnvService;
import com.quark.data.rapid.server.util.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runtime_env")
@Api(tags = { "RuntimeEnv Api" })
public class RuntimeEnvController extends BaseController {

	@Autowired
	RuntimeEnvService runtimeEnvService;

	/**
	 * 流处理环境添加接口
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "添加运行环境", notes = "添加运行环境")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "runtimeName", value = "运行环境名称", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "runtimeType", value = "运行环境类型,目前先传‘0’", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "runtimeIp", value = "运行环境ip地址", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "runtimePort", value = "运行环境端口", paramType = "query", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "runtimeUsername", value = "运行环境用户名", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "runtimePassword", value = "运行环境密码", paramType = "query", dataType = "String", required = true) })
	public ResponseBody addRuntimeEnv(@RequestParam(value = "runtimeName") String runtimeName,
			@RequestParam(value = "runtimeType") String runtimeType,
			@RequestParam(value = "runtimeIp") String runtimeIp,
			@RequestParam(value = "runtimePort") Integer runtimePort,
			@RequestParam(value = "runtimeUsername") String runtimeUsername,
			@RequestParam(value = "runtimePassword") String runtimePassword) {
		return runtimeEnvService.addRuntimeEnv(runtimeName, runtimeType, runtimeIp, runtimePort, runtimeUsername,
				runtimePassword);
	}

	/**
	 * 流处理环境添加接口
	 * 
	 * @author WangHao
	 */
	@RequestMapping(value = "/env_list", method = RequestMethod.GET)
	@ApiOperation(value = "服务器及网关列表", notes = "服务器及网关列表")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "page", value = "页数", paramType = "query", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "pageSize", value = "每页展示数量", paramType = "query", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "sort", value = "排序（时间：0，名称：1）", paramType = "query", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "sortType", value = "排序顺序（升序：0，降序：1）", paramType = "query", dataType = "Integer", required = true) })
	public ResponseBody env_list(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "sort") Integer sort,
			@RequestParam(value = "sortType") Integer sortType) {
		return runtimeEnvService.env_list(page, pageSize, sort, sortType);
	}

}
