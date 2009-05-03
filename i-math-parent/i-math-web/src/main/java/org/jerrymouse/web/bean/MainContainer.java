package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.List;

public class MainContainer {
	private List<GagetContainer> tabs;

	public void setTabs(List<GagetContainer> tabs) {
		this.tabs = tabs;
	}

	public List<GagetContainer> getTabs() {
		return tabs;
	}

	public void addTab(GagetContainer g) {
		if (tabs == null) {
			tabs = new ArrayList<GagetContainer>();
		}
		tabs.add(g);
	}
}
