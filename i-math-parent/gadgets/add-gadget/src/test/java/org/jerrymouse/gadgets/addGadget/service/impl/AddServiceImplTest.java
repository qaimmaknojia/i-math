package org.jerrymouse.gadgets.addGadget.service.impl;

import static org.junit.Assert.assertEquals;

import org.jerrymouse.gadgets.addGadget.service.AddService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddServiceImplTest {
	AddService addService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext-add-gadget.xml");
		addService = (AddService) applicationContext.getBean("addService");
	}

	@Test
	public void testAdd() throws Exception {
		int temp = (int) (addService.add(1, 2) + 0.5);
		assertEquals(3, temp);
	}
}
