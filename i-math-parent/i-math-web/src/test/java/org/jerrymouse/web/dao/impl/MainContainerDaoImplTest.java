package org.jerrymouse.web.dao.impl;

import junit.framework.TestCase;

import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.test.BaseTest;
import org.jerrymouse.web.test.SpringContextTests;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainContainerDaoImplTest extends BaseTest {
	MainContainerDao mainContainerDao;

	@Override
	public void setUp() throws Exception {
		mainContainerDao = (MainContainerDao) applicationContext
				.getBean("mainContainerDao");
	}

	public void testSave() throws Exception {
	}

}
