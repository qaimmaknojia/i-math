package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.jerrymouse.web.dao.GadgetContainerDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.appengine.api.datastore.Key;

public class MainContainer {
	GadgetContainerDao gadgetContainerDao;

	private List<Key> tabKeys = new ArrayList<Key>();

	private List<GadgetContainer> tabs = new ArrayList<GadgetContainer>();

	public MainContainer(User user) {
		tabs = user.getGadgetContainers();
	}

	public MainContainer() {
	}

	public void addTab(GadgetContainer g) {
		tabs.add(g);
	}

	public List<Key> getTabKeys() {
		return tabKeys;
	}

	public void setTabKeys(List<Key> tabKeys) {
		this.tabKeys = tabKeys;
	}

	public GadgetContainerDao getGadgetContainerDao() {
		if (gadgetContainerDao == null) {
			gadgetContainerDao = (GadgetContainerDao) new ClassPathXmlApplicationContext(
					"classpath:/applicationContext.xml")
					.getBean("gadgetContainerDao");
		}
		return gadgetContainerDao;
	}

	public void setGadgetContainerDao(GadgetContainerDao gadgetContainerDao) {
		this.gadgetContainerDao = gadgetContainerDao;
	}

	public void setTabs(List<GadgetContainer> tabs) {
		this.tabs = tabs;
	}

	public List<GadgetContainer> getTabs() {
		return tabs;
	}

}
