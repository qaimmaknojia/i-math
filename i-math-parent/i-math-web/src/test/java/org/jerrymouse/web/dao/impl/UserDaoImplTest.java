package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.User;
import org.jerrymouse.web.dao.UserDao;
import org.jerrymouse.web.test.DatastoreTestCase;

public class UserDaoImplTest extends DatastoreTestCase {
	private UserDao userDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		userDao = (UserDao) applicationContext.getBean("userDao");
	}

	public void testGetAll() throws Exception {
		userDao.getAll();
	}

	public void testFindUser() throws Exception {
		userDao.save(new User("yk", "yk@a", "123"));
		System.out.println(userDao.findUser("yk@a", "123"));
	}

	public void testSave() throws Exception {
		userDao.save(new User("yk", "yk@a", "123"));
	}

	public void testGetAdminUser() throws Exception {
		User admin = User.getAdminUser();
		System.err.println(admin.getNickName());
		System.err.println(admin.getGadgetContainers());
		admin = User.getAdminUser();
		System.err.println(admin.getNickName());
		System.err.println(admin.getGadgetContainers());
	}
}
