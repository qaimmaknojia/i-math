package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.List;

public class GagetContainer {
	private String title;
	private List<Gadget> leftGadget = new ArrayList<Gadget>();
	private List<Gadget> middleGadget = new ArrayList<Gadget>();
	private List<Gadget> rightGadget = new ArrayList<Gadget>();

	public GagetContainer() {
	}

	public GagetContainer(String string) {
		title = string;
	}

	public void addLeft(Gadget info) {
		leftGadget.add(info);
	}

	public void addMiddle(Gadget info) {
		middleGadget.add(info);
	}

	public void addRight(Gadget info) {
		rightGadget.add(info);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Gadget> getLeftGadget() {
		return leftGadget;
	}

	public void setLeftGadget(List<Gadget> leftGadget) {
		this.leftGadget = leftGadget;
	}

	public List<Gadget> getMiddleGadget() {
		return middleGadget;
	}

	public void setMiddleGadget(List<Gadget> middleGadget) {
		this.middleGadget = middleGadget;
	}

	public List<Gadget> getRightGadget() {
		return rightGadget;
	}

	public void setRightGadget(List<Gadget> rightGadget) {
		this.rightGadget = rightGadget;
	}

}
