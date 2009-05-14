package org.jerrymouse.web.dao.impl;

import java.util.List;

import org.jerrymouse.web.bean.Greeting;

public class GreetingDaoImpl extends JdoDaoSupport {
	
	public void save(Greeting greeting) {
		super.save(greeting);
	}

	@SuppressWarnings("unchecked")
	public List<Greeting> getAll() {
		return super.getAll(Greeting.class);
	}
	
}
