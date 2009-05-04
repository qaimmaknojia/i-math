package org.jerrymouse.web.dao.impl;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.GagetContainer;
import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.MainContainerDao;

public class MainContainerDaoImpl implements MainContainerDao {
	XMLDataSource xmlDataSource;
	private String fileName = "mainContainer.xml";

	@Override
	public MainContainer getMainContainer() {
		return null;
	}

	@Override
	public MainContainer initFromCode() {
		MainContainer mainContainer = new MainContainer();
		GagetContainer container1 = new GagetContainer("概率运算");
		Gadget smartcalculator = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		Gadget addGadget = new Gadget("add-gadget",
				"/gadgets/add-gadget/add-gadget.xml");
		container1.addLeft(smartcalculator);
		GagetContainer container2 = new GagetContainer("分布运算");
		container2.addLeft(addGadget);
		mainContainer.addTab(container1);
		mainContainer.addTab(container2);
		return mainContainer;
	}

	@Override
	public void save(MainContainer mainContainer) {
	}

	public XMLDataSource getXmlDataSource() {
		return xmlDataSource;
	}

	public void setXmlDataSource(XMLDataSource xmlDataSource) {
		this.xmlDataSource = xmlDataSource;
	}

}
