package org.jerrymouse.web.test;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class SpringContextTests extends TestCase {
	protected ApplicationContext applicationContext;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		applicationContext = new ClassPathXmlApplicationContext(
		"classpath:/applicationContext.xml");
	}
}
