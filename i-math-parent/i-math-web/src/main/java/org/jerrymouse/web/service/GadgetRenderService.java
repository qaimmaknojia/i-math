package org.jerrymouse.web.service;

import java.net.URL;

import org.jerrymouse.web.bean.GagetContainer;
import org.jerrymouse.web.bean.Gadget;

public interface GadgetRenderService {
	Gadget renderGadget(URL url);

	Gadget renderGadget(String url);

	GagetContainer getLayout();
}
