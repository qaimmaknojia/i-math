package org.jerrymouse.web.dao.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.jerrymouse.web.bean.GadgetContainer;
import org.jerrymouse.web.bean.User;
import org.jerrymouse.web.dao.PMF;
import org.jerrymouse.web.dao.UserDao;

public class UserDaoImpl extends JdoDaoSupport implements UserDao {

	@Override
	public User findUser(String email, String password) {
		PersistenceManager pm = PMF.getPersistenceManager();
		User u;
		try {
			Query q = pm.newQuery(User.class);
			q.setFilter("email == \"" + email + "\" && " + "password == \""
					+ password + "\"");
			q.setUnique(true);
			u = (User) q.execute();
			if (u != null) {
				for (GadgetContainer gadgetContainer : u.getGadgetContainers()) {
					gadgetContainer.toString();
				}
			}
		} finally {
			pm.close();
		}
		return u;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return super.getAll(User.class);
	}

	@Override
	public User save(User user) {
		return (User) super.save(user);
	}

	@Override
	public User hasEmail(String email) {
		if (email == null)
			return null;
		PersistenceManager pm = PMF.getPersistenceManager();
		User u;
		try {
			Query q = pm.newQuery(User.class);
			q.setFilter("email == \"" + email + "\"");
			q.setUnique(true);
			u = (User) q.execute();
		} finally {
			pm.close();
		}
		return u;
	}

}
