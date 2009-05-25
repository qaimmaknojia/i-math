package org.jerrymouse.web.dao;

import java.util.List;

import org.jerrymouse.web.bean.User;

public interface UserDao {

	User findUser(String email, String password);

	List<User> getAll();

	User save(User user);

	User hasEmail(String email);

}
