package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.test.BaseTest;

public class GadgetDaoImplTest extends BaseTest {
	GadgetDaoImpl gadgetDaoImpl;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		gadgetDaoImpl = new GadgetDaoImpl();
	}

	public void testSave() throws Exception {
		gadgetDaoImpl.save(new Gadget());
	}
}
