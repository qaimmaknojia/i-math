package org.jerrymouse.web.service.impl;

import javax.jws.WebService;

import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.service.ContainerService;

public class ContainerServiceImpl implements ContainerService {
	MainContainerDao mainContainerDao;
	private static boolean inited = false;

	@Override
	public MainContainer getMainContainer() {
		if (!inited) {
			mainContainerDao.initMainContainer();
			inited = true;
		}
		return mainContainerDao.getMainContainer();

	}

}
