package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MainContainer {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;

	@Persistent
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

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

}
