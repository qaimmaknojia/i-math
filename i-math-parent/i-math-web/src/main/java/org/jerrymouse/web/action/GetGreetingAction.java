package org.jerrymouse.web.action;

import java.util.List;

import org.jerrymouse.web.bean.Greeting;
import org.jerrymouse.web.dao.impl.GreetingDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class GetGreetingAction extends ActionSupport {
	private GreetingDaoImpl greetingDao;
	private List<Greeting> greetings;
	private int lenth;

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public List<Greeting> getGreetings() {
		greetings = greetingDao.getAll();
		return greetings;
	}

	public void setGreetingDao(GreetingDaoImpl greetingDao) {
		this.greetingDao = greetingDao;
	}

	public int getLenth() {
		lenth=getGreetings().size();
		return lenth;
	}

	public void setLenth(int lenth) {
		this.lenth = lenth;
	}

	public GreetingDaoImpl getGreetingDao() {
		return greetingDao;
	}

	public void setGreetings(List<Greeting> greetings) {
		this.greetings = greetings;
	}
}
