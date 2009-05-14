package org.jerrymouse.web.dao;

import java.util.List;

import org.jerrymouse.web.bean.GadgetContainer;

import com.google.appengine.api.datastore.Key;

public interface GadgetContainerDao {

	void save(GadgetContainer gadgetContainer);

	GadgetContainer getById(Key id);

	List<GadgetContainer> getAll();

	List<GadgetContainer> getByKeyList(List<Key> tabKeys);
}
