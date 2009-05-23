package org.jerrymouse.web.service.impl;

import org.jerrymouse.web.service.GadgetRenderService;
import org.jerrymouse.web.test.DatastoreTestCase;

public class GadgetRenderServiceImplTest extends DatastoreTestCase {
	GadgetRenderService gadgetRenderService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gadgetRenderService = (GadgetRenderService) applicationContext
				.getBean("gadgetRenderService");
	}
}
