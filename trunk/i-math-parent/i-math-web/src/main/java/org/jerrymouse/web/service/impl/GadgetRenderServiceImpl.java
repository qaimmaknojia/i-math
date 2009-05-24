package org.jerrymouse.web.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.service.ContainerService;
import org.jerrymouse.web.service.GadgetRenderService;

public class GadgetRenderServiceImpl implements GadgetRenderService {
	MainContainerDao mainContainerDao;
	ContainerService containerService;
	GadgetDao gadgetDao;

	public GadgetDao getGadgetDao() {
		return gadgetDao;
	}

	public void setGadgetDao(GadgetDao gadgetDao) {
		this.gadgetDao = gadgetDao;
	}

	private Gadget renderGadget(String htmlId, URL url) {
		// Debugger.log("build:" + url);
		Gadget gadget = null;
		try {
			gadget = new Gadget(url);
			gadget.setHtmlId(htmlId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Debugger.log("get:" + gadget.getId());
		return gadget;
	}

	@Override
	public Gadget renderGadget(String htmlId, String url) {
		// Debugger.log("build:" + url);
		Gadget gadget = null;
		try {
			gadget = renderGadget(htmlId, new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return gadget;
	}

	@Override
	public MainContainer getContainer() {
		return containerService.getMainContainer();
	}

	public MainContainerDao getMainContainerDao() {
		return mainContainerDao;
	}

	public void setMainContainerDao(MainContainerDao mainContainerDao) {
		this.mainContainerDao = mainContainerDao;
	}

	public void setContainerService(ContainerService containerService) {
		this.containerService = containerService;
	}

	public ContainerService getContainerService() {
		return containerService;
	}

	@Override
	public List<Gadget> getAllGadgets() {
		return gadgetDao.getAll();
	}

}
