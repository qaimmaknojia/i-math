package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.GadgetContainer;
import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.GadgetContainerDao;
import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.test.DatastoreTestCase;

public class MainContainerDaoImplTest extends DatastoreTestCase {
	private MainContainerDaoImpl mainContainerDao;
	private GadgetContainerDao gadgetContainerDao;
	private GadgetDao gadgetDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		mainContainerDao = (MainContainerDaoImpl) applicationContext
				.getBean("mainContainerDao");
		gadgetContainerDao = (GadgetContainerDao) applicationContext
				.getBean("gadgetContainerDao");
		gadgetDao = (GadgetDao) applicationContext.getBean("gadgetDao");
	}

	public void atestInit() throws Exception {
		mainContainerDao.getMainContainer();
	}

	public void atestSave() throws Exception {
		Gadget smartcalculator = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		gadgetDao.save(smartcalculator);

		GadgetContainer gadgetContainer = new GadgetContainer("概率运算");
		gadgetContainer.addLeft(smartcalculator);

		gadgetContainerDao.save(gadgetContainer);

		System.err.println(gadgetContainerDao.getById(gadgetContainer.getId())
				.getLeftGadgetKeys());

		MainContainer mainContainer = new MainContainer();
		mainContainer.addTab(gadgetContainer);

		mainContainerDao.save(mainContainer);
		MainContainer mainContainer2 = mainContainerDao.getById(mainContainer
				.getId());
		System.err.println(mainContainer2);

	}

	public void testGet() throws Exception {

		MainContainer mainContainer = mainContainerDao.getMainContainer();
		System.out.println(mainContainer);
	}

}
