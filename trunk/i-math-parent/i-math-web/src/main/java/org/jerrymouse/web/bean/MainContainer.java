package org.jerrymouse.web.bean;

import java.util.List;

import org.jerrymouse.web.dao.MainContainerDao;

public class MainContainer {
	private List<GagetContainer> tabs;

	public void setTabs(List<GagetContainer> tabs) {
		this.tabs = tabs;
	}

	public List<GagetContainer> getTabs() {
		return tabs;
	}

	public void addTab() {

	}
}
