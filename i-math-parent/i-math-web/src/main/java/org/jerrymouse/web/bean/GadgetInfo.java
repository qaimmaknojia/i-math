package org.jerrymouse.web.bean;

public class GadgetInfo {
	protected String name;
	private String relativeUrl;

	public GadgetInfo(String name, String relativeUrl) {
		super();
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
}
