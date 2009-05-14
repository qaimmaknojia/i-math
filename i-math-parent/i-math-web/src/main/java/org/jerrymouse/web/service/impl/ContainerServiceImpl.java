package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.service.ContainerService;

public class ContainerServiceImpl implements ContainerService {
	MainContainerDao mainContainerDao;

	@Override
	public MainContainer getMainContainer() {
		return mainContainerDao.initFromCode();
	}

	@Override
	public void init() {
		mainContainerDao.init();
	}

	public void setMainContainerDao(MainContainerDao mainContainerDao) {
		this.mainContainerDao = mainContainerDao;
	}

}
