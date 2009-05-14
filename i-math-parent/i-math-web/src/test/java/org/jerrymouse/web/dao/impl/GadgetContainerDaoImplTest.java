package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.GadgetContainer;
import org.jerrymouse.web.dao.GadgetContainerDao;
import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.test.DatastoreTestCase;

public class GadgetContainerDaoImplTest extends DatastoreTestCase {
	GadgetContainerDao gadgetContainerDao;
	GadgetDao gadgetDao;

	protected void setUp() throws Exception {
		super.setUp();
		gadgetContainerDao = (GadgetContainerDao) applicationContext
				.getBean("gadgetContainerDao");
		gadgetDao = (GadgetDao) applicationContext.getBean("gadgetDao");
	}

	public void atestSave() throws Exception {
		Gadget smartcalculator = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		gadgetDao.save(smartcalculator);

		GadgetContainer gadgetContainer = new GadgetContainer("概率运算");

		gadgetContainerDao.save(gadgetContainer);
	}

	public void testGet() throws Exception {

		GadgetContainer gadgetContainer = new GadgetContainer("概率运算");
		Gadget smartcalculator = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		gadgetDao.save(smartcalculator);
		System.out.println(smartcalculator.getId());

		gadgetContainer.addLeft(smartcalculator);
		gadgetContainerDao.save(gadgetContainer);
		
		System.out.println(gadgetContainer.getId());

		for (GadgetContainer gadgetContainer2 : gadgetContainerDao.getAll()) {
			System.err.println(gadgetContainer2.getLeftGadget());
		}

		GadgetContainer gadgetContainer3 = gadgetContainerDao
				.getById(gadgetContainer.getId());
		System.err.println(gadgetContainer3.getLeftGadget());
		System.err.println(gadgetContainer3.getMiddleGadget());
		System.err.println(gadgetContainer3.getRightGadget());

	}

}
