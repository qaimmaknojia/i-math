package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.bean.User;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.service.ContainerService;
import org.jerrymouse.web.service.UserService;

public class ContainerServiceImpl implements ContainerService {
	MainContainerDao mainContainerDao;
	UserService userService;

	@Override
	public MainContainer getMainContainer() {
		User user = userService.currentUser();
		return new MainContainer(user);
	}
	

	public void setMainContainerDao(MainContainerDao mainContainerDao) {
		this.mainContainerDao = mainContainerDao;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public MainContainerDao getMainContainerDao() {
		return mainContainerDao;
	}

}
