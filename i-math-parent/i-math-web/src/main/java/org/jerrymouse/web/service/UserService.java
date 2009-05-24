package org.jerrymouse.web.service;

import org.jerrymouse.web.bean.User;

public interface UserService {
	User verify(String email, String password);

	User currentUser();
	
}
