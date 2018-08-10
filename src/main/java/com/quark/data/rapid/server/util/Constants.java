package com.quark.data.rapid.server.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	// 流式工作流是否已删除（0：否、1：是）
	public static final String STREAM_WORKFLOW_NOT_DELETE = "0";
	public static final String STREAM_WORKFLOW_DELETED = "1";

	// 项目未删除
	public static final String PROJECT_NOT_DELETE = "0";

	// 流式工作流节点类型（0：Source、1：Processor、2：Sink）
	public static final String SOURCE = "0";
	public static final String PROCESSOR = "1";
	public static final String SINK = "2";

	// 流式工作流节点所属类型（0：通用节点、1：租户定制节点）
	public static final String COMMON = "0";
	public static final String PRIVATE = "1";


	// 流处理运行环境类型
	public static final Map<String, String> RUNTIME_TYPE_MAP = new HashMap<>();
	static {
		RUNTIME_TYPE_MAP.put("0", "FLINK");
		//TODO 其他类型
	}
}
