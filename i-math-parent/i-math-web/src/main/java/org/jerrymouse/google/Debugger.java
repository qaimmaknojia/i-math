package org.jerrymouse.google;

import com.opensymphony.xwork2.ActionSupport;

public class Debugger extends ActionSupport {
	private static StringBuilder logbuilder=new StringBuilder();
	private String log;

	public String getLog() {
		return logbuilder.toString();
	}

	public static void log(String str) {
		logbuilder.append(str + "<br />\n");
	}
}
