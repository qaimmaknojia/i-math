package org.jerrymouse.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextAwareImpl implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	public ApplicationContextAwareImpl() {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public Object getBean(String name) {
		return applicationContext.getBean(name);
	}

}
