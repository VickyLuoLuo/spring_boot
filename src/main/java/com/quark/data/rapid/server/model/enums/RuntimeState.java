package com.quark.data.rapid.server.model.enums;

import com.alibaba.druid.util.StringUtils;

/**
 * flink 运行状态
 * 
 * @author WangHao 2018年8月8日
 */
public enum RuntimeState {

	RUNNING("0", "RUNNING"), FINISHED("1", "FINISHED"), CANAELING("2", "CANAELING"), CANCELED("3",
			"CANCELED"), FAILED("4", "FAILED");

	private final String key;
	private final String value;

	private RuntimeState(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	/**
	 * 根据value获取key
	 */
	public static String getKeyByValue(String value) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		for (RuntimeState Runtime : RuntimeState.values()) {
			if (Runtime.getValue().equals(value)) {
				return Runtime.getKey();
			}
		}
		return null;
	}

	/**
	 * 根据Key获取Value
	 */
	public static String getValueByKey(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		for (RuntimeState Runtime : RuntimeState.values()) {
			if (Runtime.getKey().equals(key)) {
				return Runtime.getValue();
			}
		}
		return null;
	}
}
