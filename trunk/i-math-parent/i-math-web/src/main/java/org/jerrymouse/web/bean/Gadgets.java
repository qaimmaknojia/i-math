package org.jerrymouse.web.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

public class Gadgets {
	private static Map<String, Gadget> gadgets = init();
	private static String urlBase;

	private static Map<String, Gadget> init() {
		Map<String, Gadget> gadgets = new HashMap<String, Gadget>();
		gadgets.put("add-gadget", new Gadget(Gadgets.class
				.getResourceAsStream("/gadgets/add-gadget/add-gadget.xml")));
		return gadgets;
	}

}
