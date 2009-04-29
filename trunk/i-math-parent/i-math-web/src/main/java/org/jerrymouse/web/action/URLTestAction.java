package org.jerrymouse.web.action;

import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.opensymphony.xwork2.ActionSupport;

public class URLTestAction extends ActionSupport {
	private String url;
	private String data;

	@Override
	public String execute() throws Exception {
		InputStream inputStream = new URL(url).openStream();
		data = IOUtils.toString(inputStream);
		return super.execute();
	}

	public String getData() {
		return data;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
