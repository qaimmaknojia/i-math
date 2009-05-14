package org.jerrymouse.web.dao;

import org.jerrymouse.web.bean.MainContainer;

import com.google.appengine.api.datastore.Key;

public interface MainContainerDao {
	MainContainer getMainContainer();

	void save(MainContainer mainContainer);

	MainContainer getById(Key id);

	void init();

	MainContainer initFromCode();
}
