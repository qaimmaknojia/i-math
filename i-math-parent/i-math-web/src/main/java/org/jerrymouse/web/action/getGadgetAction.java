package org.jerrymouse.web.action;

import java.net.URL;

import net.sf.json.JSONObject;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.service.GadgetRenderService;

import com.opensymphony.xwork2.ActionSupport;

public class getGadgetAction extends ActionSupport {
	private String url;

	private GadgetRenderService gadgetRenderService;

	private Gadget gadget;

	@Override
	public String execute() throws Exception {
		gadget = gadgetRenderService.renderGadget(new URL(url));
		return SUCCESS;
	}

	public void setGadgetRenderService(GadgetRenderService gadgetRenderService) {
		this.gadgetRenderService = gadgetRenderService;
	}

	public Gadget getGadget() {
		return gadget;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
