package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.test.SpringContextTests;

public class MainContainerDaoImplTest extends SpringContextTests {
	MainContainerDao mainContainerDao;

	@Override
	protected void onSetUp() throws Exception {
		mainContainerDao = (MainContainerDao) applicationContext
				.getBean("mainContainerDao");
	}

	public void testSave() throws Exception {
	}

}
