package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.test.SpringContextTests;
import org.junit.Before;
import org.junit.Test;

public class MainContainerDaoImplTest extends SpringContextTests {
	MainContainerDao mainContainerDao;

	@Override
	protected void onSetUp() throws Exception {
		mainContainerDao = (MainContainerDao) applicationContext
				.getBean("mainContainerDao");
	}

	public void testSave() throws Exception {
		// mainContainerDao.save(null);
	}

}
