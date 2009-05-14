package org.jerrymouse.web.dao.impl;

import java.util.List;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.dao.GadgetDao;

import com.google.appengine.api.datastore.Key;

public class GadgetDaoImpl extends JdoDaoSupport implements GadgetDao {

	public void save(Gadget gadget) {
		super.save(gadget);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gadget> getByKeyList(List<Key> keyList) {
		return super.getByKeyList(keyList, Gadget.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gadget> getAll() {
		return super.getAll(Gadget.class);
	}

}
