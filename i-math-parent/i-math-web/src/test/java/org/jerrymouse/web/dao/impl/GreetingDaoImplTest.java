package org.jerrymouse.web.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.jerrymouse.web.bean.Greeting;
import org.jerrymouse.web.dao.PMF;
import org.jerrymouse.web.test.BaseTest;
import org.jerrymouse.web.test.DatastoreTestCase;

public class GreetingDaoImplTest extends DatastoreTestCase {

	private GreetingDaoImpl greetingDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		greetingDao = (GreetingDaoImpl) applicationContext
				.getBean("greetingDao");
	}

	public void testSave() throws Exception {
		// System.out.println("ok");
		// System.out.println(greetingDao);
		greetingDao.save(new Greeting("hello", new Date()));
		// EntityManager pm = PMF.get().createEntityManager();
		// pm.persist(new Greeting("c", new Date()));
	}

	public void testGetAll() throws Exception {
		List<Greeting> Greetings = greetingDao.getAll();
		System.out.println(Greetings);
	}
}
