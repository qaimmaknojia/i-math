package org.jerrymouse.web.service;

import java.util.List;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.MainContainer;

public interface GadgetRenderService {

	Gadget renderGadget(String htmlId, String url);

	MainContainer getContainer();

	List<Gadget> getAllGadgets();

	boolean addGadget(String name, String description, String url);
}
