package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.bean.User;
import org.jerrymouse.web.service.ContainerService;
import org.jerrymouse.web.service.UserService;
import org.jerrymouse.web.test.DatastoreTestCase;

public class UserServiceImplTest extends DatastoreTestCase {
	UserService userService;
	ContainerService containerService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		userService = (UserService) applicationContext.getBean("userService");
		containerService = (ContainerService) applicationContext
				.getBean("containerService");
	}

	public void testVerify() throws Exception {
		User user = userService.verify("bb", "c");
		System.out.println(user);
	}
}
