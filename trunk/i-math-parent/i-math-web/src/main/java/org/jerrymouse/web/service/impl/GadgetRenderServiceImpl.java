package org.jerrymouse.web.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jerrymouse.google.Debugger;
import org.jerrymouse.web.bean.GagetContainer;
import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.service.GadgetRenderService;

public class GadgetRenderServiceImpl implements GadgetRenderService {

	@Override
	public Gadget renderGadget(URL url) {
		// Debugger.log("build:" + url);
		Gadget gadget = null;
		try {
			gadget = new Gadget(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Debugger.log("get:" + gadget.getId());
		return gadget;
	}

	@Override
	public Gadget renderGadget(String url) {
		// Debugger.log("build:" + url);
		Gadget gadget = null;
		try {
			gadget = renderGadget(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return gadget;
	}

	@Override
	public GagetContainer getLayout() {
		return new GagetContainer();
	}

}
