package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.test.DatastoreTestCase;

public class GadgetDaoImplTest extends DatastoreTestCase {
	GadgetDaoImpl gadgetDaoImpl;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		gadgetDaoImpl = (GadgetDaoImpl) applicationContext.getBean("gadgetDao");
	}

	public void testSave() throws Exception {
		Gadget gadget = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		gadgetDaoImpl.save(gadget);
		System.err.println(gadget.getId());
		System.err.println(gadget.getHtmlId());
		System.err.println(gadget.getRelativeUrl());
	}

	public void testGet() {
		Gadget gadget = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		gadgetDaoImpl.save(gadget);
		gadget = (Gadget) gadgetDaoImpl.getObjectById(Gadget.class, gadget
				.getId());
		System.err.println(gadget.getId());
		System.err.println(gadget.getHtmlId());
		System.err.println(gadget.getRelativeUrl());

	}
}
