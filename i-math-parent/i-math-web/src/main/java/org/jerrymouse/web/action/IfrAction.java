package org.jerrymouse.web.action;

import java.net.URL;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.service.GadgetRenderService;

import com.opensymphony.xwork2.ActionSupport;

public class IfrAction extends ActionSupport {
	private String url;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
