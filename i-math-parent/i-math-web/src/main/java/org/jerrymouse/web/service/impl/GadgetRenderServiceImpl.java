package org.jerrymouse.web.service.impl;

import java.io.IOException;
import java.net.URL;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.service.GadgetRenderService;

public class GadgetRenderServiceImpl implements GadgetRenderService {

	@Override
	public Gadget renderGadget(URL url) {
		Gadget gadget = null;
		try {
			gadget = new Gadget(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gadget;
	}

}
