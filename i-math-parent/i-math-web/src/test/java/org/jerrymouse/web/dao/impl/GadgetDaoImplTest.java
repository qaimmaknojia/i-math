package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.test.DatastoreTestCase;

public class GadgetDaoImplTest extends DatastoreTestCase {
	GadgetDao gadgetDaoImpl;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		gadgetDaoImpl = (GadgetDao) applicationContext.getBean("gadgetDao");
	}

	public void testSave() throws Exception {
		Gadget gadget = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		gadgetDaoImpl.save(gadget);
		System.out.println(gadget.getId());
	}
}
