package org.jerrymouse.web.dao.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.jerrymouse.web.bean.Greeting;
import org.jerrymouse.web.dao.PMF;

public class GreetingDaoImpl {

	public void save(Greeting greeting) {
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			pm.makePersistent(greeting);
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Greeting> getAll() {
		List<Greeting> greetings;
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			Query query = pm.newQuery(Greeting.class);
			greetings = (List<Greeting>) query.execute();
			greetings.size();
		} finally {
			pm.close();
		}
		// String query = "select g from " + Greeting.class.getName();
		return greetings;
	}
}
