package org.jerrymouse.web.bean;

import java.util.Random;

import javax.jdo.annotations.Persistent;

public class GadgetInfo {
	private String htmlId;
	protected String name;
	@Persistent
	private String relativeUrl;

	public GadgetInfo(String name, String relativeUrl) {
		this.name = name;
		this.relativeUrl = relativeUrl;
	}

	public GadgetInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelativeUrl() {
		return relativeUrl;
	}

	public void setRelativeUrl(String relativeUrl) {
		this.relativeUrl = relativeUrl;
	}

	public String getHtmlId() {
		if (htmlId == null) {
			htmlId = name
					+ new Integer((int) (Math.random() * 1000)).toString();
		}
		return htmlId;
	}

	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}

}
