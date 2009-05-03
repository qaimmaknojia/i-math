package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.service.ContainerService;

public class ContainerServiceImpl implements ContainerService {
	MainContainerDao mainContainerDao;
	
	@Override
	public void createXML() {
		MainContainer mainContainer=mainContainerDao.initFromCode();
		mainContainerDao.save(mainContainerDao);
	}

}
