package org.jerrymouse.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.jerrymouse.web.dao.PMF;

import com.google.appengine.api.datastore.Key;

public class JdoDaoSupport {
	public Key getObjectId(Object object) {
		Key key;
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			key = (Key) pm.getObjectId(object);
		} finally {
			pm.close();
		}
		return key;
	}

	protected void save(Object object) {
		PersistenceManager pm = PMF.getPersistenceManager();
		Transaction transaction = pm.currentTransaction();

		try {
			transaction.begin();
			pm.makePersistent(object);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	protected List getAll(Class class1) {
		List objects;
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			Query query = pm.newQuery(class1);
			objects = (List) query.execute();
			objects.size();
		} finally {
			pm.close();
		}
		return objects;
	}

	public Object getObjectById(Class class1, Key key) {
		Object object;
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			object = pm.getObjectById(class1, key);
		} finally {
			pm.close();
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public List getByKeyList(List<Key> keyList, Class class1) {
		List list = new ArrayList();
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			for (Key key : keyList) {
				list.add(pm.getObjectById(class1, key));
			}
		} finally {
			pm.close();
		}
		return list;
	}
}
