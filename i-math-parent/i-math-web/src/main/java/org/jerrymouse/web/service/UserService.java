package org.jerrymouse.web.service;

import org.jerrymouse.web.bean.User;

public interface UserService {
	User verify(String email, String password);

	boolean hasEmail(String email);

	User currentUser();

	User signIn(String email, String nickName, String password);

}
