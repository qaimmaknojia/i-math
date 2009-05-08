package org.jerrymouse.web.action;

import java.util.Date;
import java.util.List;

import org.jerrymouse.web.bean.Greeting;
import org.jerrymouse.web.dao.impl.GreetingDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class SaveGreetingAction extends ActionSupport {
	private GreetingDaoImpl greetingDao;
	private String content;

	@Override
	public String execute() throws Exception {
		greetingDao.save(new Greeting(content, new Date()));
		return super.execute();
	}

	public GreetingDaoImpl getGreetingDao() {
		return greetingDao;
	}

	public void setGreetingDao(GreetingDaoImpl greetingDao) {
		this.greetingDao = greetingDao;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
