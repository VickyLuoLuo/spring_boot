package com.quark.data.rapid.server.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myprop")
public class PropertiesUtil {

	// topology 服务器 地址
	private String topologip;
	private String topologrun;
	private String topologstop;
	private String topologjoblist;

	public String getTopologip() {
		return topologip;
	}

	public void setTopologip(String topologip) {
		this.topologip = topologip;
	}

	public String getTopologrun() {
		return topologrun;
	}

	public void setTopologrun(String topologrun) {
		this.topologrun = topologrun;
	}

	public String getTopologstop() {
		return topologstop;
	}

	public void setTopologstop(String topologstop) {
		this.topologstop = topologstop;
	}

	public String getTopologjoblist() {
		return topologjoblist;
	}

	public void setTopologjoblist(String topologjoblist) {
		this.topologjoblist = topologjoblist;
	}
}
