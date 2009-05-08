package org.jerrymouse.web.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import org.jerrymouse.web.bean.Greeting;
import org.jerrymouse.web.dao.PMF;

public class GreetingDaoImpl {

	public void save(Greeting greeting) {
		EntityManager pm = PMF.get().createEntityManager();
		pm.persist(greeting);
		pm.close();
	}

	@SuppressWarnings("unchecked")
	public List<Greeting> getAll() {
		EntityManager pm = PMF.get().createEntityManager();
		String query = "select g from " + Greeting.class.getName();
		List<Greeting> greetings = (List<Greeting>) pm.createQuery(query)
				.getResultList();
		greetings.size();
		pm.close();
		return greetings;
	}
}
