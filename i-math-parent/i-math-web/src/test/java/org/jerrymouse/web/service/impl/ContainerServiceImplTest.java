package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.GadgetContainer;
import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.service.ContainerService;
import org.jerrymouse.web.test.DatastoreTestCase;

public class ContainerServiceImplTest extends DatastoreTestCase {
	ContainerService containerService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		containerService = (ContainerService) applicationContext
				.getBean("containerService");
	}

	public void testGetMainContainer() throws Exception {
		MainContainer main = containerService.getMainContainer();
		System.err.println(main);
		for (GadgetContainer gadgetContainer : main.getTabs()) {
			// leftGadget,middleGadget,rightGadget,title
			System.err.println(gadgetContainer.getTitle());
			for (Gadget g : gadgetContainer.getLeftGadget()) {
				System.err.println(g.getName());
				System.err.println(g.getHtmlId());
				System.err.println(g.getRelativeUrl());
			}
			for (Gadget g : gadgetContainer.getMiddleGadget()) {
				System.err.println(g.getName());
				System.err.println(g.getHtmlId());
				System.err.println(g.getRelativeUrl());
			}
			for (Gadget g : gadgetContainer.getRightGadget()) {
				System.err.println(g.getName());
				System.err.println(g.getHtmlId());
				System.err.println(g.getRelativeUrl());
			}
		}

	}

}
