package org.jerrymouse.web.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;

import org.jerrymouse.web.bean.Greeting;
import org.jerrymouse.web.dao.PMF;
import org.jerrymouse.web.test.DatastoreTestCase;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

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
		// greetingDao.save(new Greeting("hello", new Date()));
		PersistenceManager pm = PMF.getPersistenceManager();
		pm.makePersistent(new Greeting("c", new Date()));

	}

	public void testGetAll() throws Exception {
		Greeting greeting = new Greeting("hello", new Date());
		List<Key> list = new ArrayList<Key>();
		list.add(KeyFactory.createKey("aaa", 111));
		greeting.setStrings(list);
		greetingDao.save(greeting);
		List<Greeting> Greetings = greetingDao.getAll();
		for (Greeting greeting2 : Greetings) {
			System.out.println(greeting2.getId());
			System.out.println(greeting2.getStrings());
		}
	}
}
