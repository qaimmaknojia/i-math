package org.jerrymouse.web.dao.impl;

import java.io.File;

public class XMLDataSource {
	private File parent = new File("src/main/resources/org/jerrymouse/bean/");

	public void setParent(File parent) {
		this.parent = parent;
	}

	public File getParent() {
		return parent;
	}
}
