package org.jerrymouse.web.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.jerrymouse.web.bean.GadgetInfo;
import org.jerrymouse.web.bean.GagetContainer;
import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.MainContainerDao;

public class MainContainerDaoImpl implements MainContainerDao {
	XMLDataSource xmlDataSource;

	@Override
	public MainContainer getMainContainer() {
		return null;
	}

	@Override
	public MainContainer initFromCode() {
		MainContainer mainContainer = new MainContainer();
		GagetContainer container1 = new GagetContainer("概率运算");
		GadgetInfo smartcalculator = new GadgetInfo("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");
		GadgetInfo addGadget = new GadgetInfo("add-gadget",
				"/gadgets/add-gadget/add-gadget.xml");
		container1.addLeft(smartcalculator);
		container1.addMiddle(addGadget);
		GagetContainer container2 = new GagetContainer("分布运算");
		container2.addMiddle(smartcalculator);
		container2.addLeft(addGadget);
		mainContainer.addTab(container1);
		mainContainer.addTab(container2);
		return mainContainer;
	}

	@Override
	public void save(MainContainer mainContainer) {
		try {
			IOUtils.write("good", new FileOutputStream(xmlDataSource
					.getParent().getAbsolutePath()
					+ "aaaaaa"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public XMLDataSource getXmlDataSource() {
		return xmlDataSource;
	}

	public void setXmlDataSource(XMLDataSource xmlDataSource) {
		this.xmlDataSource = xmlDataSource;
	}

}
