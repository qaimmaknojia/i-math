package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.test.DatastoreTestCase;

public class MainContainerDaoImplTest extends DatastoreTestCase {
	private MainContainerDao mainContainerDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		mainContainerDao = (MainContainerDao) applicationContext
				.getBean("mainContainerDao");
	}

	// public void testInitMainContainer() throws Exception {
	// mainContainerDao.initMainContainer();
	// }

	public void testSave() throws Exception {
		mainContainerDao.save(new MainContainer());
	}
}
