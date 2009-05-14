package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.service.ContainerService;
import org.jerrymouse.web.test.DatastoreTestCase;
import org.jerrymouse.web.test.SpringContextTests;

public class ContainerServiceImplTest extends DatastoreTestCase {
	ContainerService containerService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		containerService = (ContainerService) applicationContext
				.getBean("containerService");
	}

	// public void testGetMainContainer() throws Exception {
	// containerService.getMainContainer();
	// }

}
