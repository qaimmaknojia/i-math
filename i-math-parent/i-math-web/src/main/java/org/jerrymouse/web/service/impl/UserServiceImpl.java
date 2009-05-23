package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.bean.User;
import org.jerrymouse.web.dao.UserDao;
import org.jerrymouse.web.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Override
	public User verify(String email, String password) {
		return userDao.findUser(email, password);
	}

	@Override
	public User currentUser() {
		// if no
		User admin = User.getAdminUser();
		User anonymous = new User("anonymous", "anonymous@imath.org",
				"anonymous");
		anonymous.setGadgetContainers(admin.getGadgetContainers());
		return anonymous;
	}

}
