package org.jerrymouse.web.dao;

import org.jerrymouse.web.bean.MainContainer;

public interface MainContainerDao {
	MainContainer getMainContainer();

	MainContainer initFromCode();

	void save(MainContainer mainContainer);
}
