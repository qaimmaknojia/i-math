package org.jerrymouse.web.service;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.MainContainer;

public interface GadgetRenderService {

	Gadget renderGadget(String htmlId, String url);

	MainContainer getContainer();
}
