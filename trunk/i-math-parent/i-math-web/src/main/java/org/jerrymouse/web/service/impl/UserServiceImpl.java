package org.jerrymouse.web.service.impl;

import java.util.List;

import org.directwebremoting.WebContextFactory;
import org.jerrymouse.web.bean.GadgetContainer;
import org.jerrymouse.web.bean.User;
import org.jerrymouse.web.dao.UserDao;
import org.jerrymouse.web.service.UserService;

import com.opensymphony.xwork2.ActionContext;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Override
	public User verify(String email, String password) {
		User user = userDao.findUser(email, password);
		putInSession("user_email", user.getEmail());
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User currentUser() {
		// if no
		String email = null;
		User user = null;
		email = (String) getFromSession("user_email");
		user = userDao.hasEmail(email);
		if (user == null) {
			User admin = User.getAdminUser();
			user = new User("anonymous", "anonymous@imath.org", "anonymous");
			user.setGadgetContainers(admin.getGadgetContainers());
		}
		return user;
	}

	@Override
	public boolean hasEmail(String email) {
		return userDao.hasEmail(email) == null ? false : true;
	}

	@Override
	public User signIn(String email, String nickName, String password) {
		User admin = User.getAdminUser();
		User user = new User(nickName, email, password);
		List<GadgetContainer> gadgetContainers = admin.getGadgetContainers();
		for (GadgetContainer gadgetContainer : gadgetContainers) {
			GadgetContainer newOne = new GadgetContainer(gadgetContainer
					.getTitle());
			newOne.setLeftGadgetKeys(gadgetContainer.getLeftGadgetKeys());
			newOne.setMiddleGadgetKeys(gadgetContainer.getMiddleGadgetKeys());
			newOne.setRightGadgetKeys(gadgetContainer.getRightGadgetKeys());
			user.addGadgetContainer(newOne);
		}
		putInSession("user_email", user.getEmail());

		return userDao.save(user);
	}

	private void putInSession(String str, Object obj) {
		try {
			WebContextFactory.get().getSession().setAttribute(str, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object getFromSession(String str) {
		Object object = null;
		try {
			object = WebContextFactory.get().getSession().getAttribute(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
