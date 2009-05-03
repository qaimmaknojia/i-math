package org.jerrymouse.web.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class SpringContextTests extends
		AbstractDependencyInjectionSpringContextTests {

	public SpringContextTests() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext-web.xml");
		setPopulateProtectedVariables(true);
		setAutowireMode(AUTOWIRE_BY_NAME);

	}
}
