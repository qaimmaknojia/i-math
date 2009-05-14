package org.jerrymouse.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import org.jerrymouse.web.bean.GadgetContainer;
import org.jerrymouse.web.dao.GadgetContainerDao;
import org.jerrymouse.web.dao.PMF;

import com.google.appengine.api.datastore.Key;

public class GadgetContainerDaoImpl extends JdoDaoSupport implements
		GadgetContainerDao {

	@Override
	public void save(GadgetContainer gadgetContainer) {
		super.save(gadgetContainer);
	}

	@Override
	public GadgetContainer getById(Key id) {
		GadgetContainer object;
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			object = pm.getObjectById(GadgetContainer.class, id);
			object.getLeftGadgetKeys();
			object.getMiddleGadgetKeys();
			object.getRightGadgetKeys();
		} finally {
			pm.close();
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GadgetContainer> getAll() {
		return super.getAll(GadgetContainer.class);
	}

	@Override
	public List<GadgetContainer> getByKeyList(List<Key> tabKeys) {
		List<GadgetContainer> list = new ArrayList<GadgetContainer>();
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			for (Key key : tabKeys) {
				GadgetContainer container = pm.getObjectById(
						GadgetContainer.class, key);
				container.getLeftGadgetKeys();
				container.getMiddleGadgetKeys();
				container.getRightGadgetKeys();
				list.add(container);
			}
		} finally {
			pm.close();
		}
		return list;
	}

}
