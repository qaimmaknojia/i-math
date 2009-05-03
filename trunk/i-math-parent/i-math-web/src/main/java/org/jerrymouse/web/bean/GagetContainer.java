package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.List;

public class GagetContainer {
	private String title;
	private List<GadgetInfo> leftGadget = new ArrayList<GadgetInfo>();
	private List<GadgetInfo> middleGadget = new ArrayList<GadgetInfo>();
	private List<GadgetInfo> rightGadget = new ArrayList<GadgetInfo>();

	public GagetContainer() {
		leftGadget.add(new GadgetInfo("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml"));
		middleGadget.add(new GadgetInfo("add-gadget",
				"/gadgets/add-gadget/add-gadget.xml"));
	}

	public GagetContainer(String string) {
		title = string;
	}

	public void addLeft(GadgetInfo info) {
		leftGadget.add(info);
	}

	public void addMiddle(GadgetInfo info) {
		middleGadget.add(info);
	}

	public void addRight(GadgetInfo info) {
		rightGadget.add(info);
	}

	public List<GadgetInfo> getLeftGadget() {
		return leftGadget;
	}

	public void setLeftGadget(List<GadgetInfo> leftGadget) {
		this.leftGadget = leftGadget;
	}

	public List<GadgetInfo> getMiddleGadget() {
		return middleGadget;
	}

	public void setMiddleGadget(List<GadgetInfo> middleGadget) {
		this.middleGadget = middleGadget;
	}

	public List<GadgetInfo> getRightGadget() {
		return rightGadget;
	}

	public void setRightGadget(List<GadgetInfo> rightGadget) {
		this.rightGadget = rightGadget;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
