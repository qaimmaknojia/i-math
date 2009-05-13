package org.jerrymouse.web.dao.impl;

import javax.jdo.PersistenceManager;
import javax.persistence.EntityManager;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.GagetContainer;
import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.dao.PMF;

public class MainContainerDaoImpl implements MainContainerDao {

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
		container1.addLeft(addGadget);
		GagetContainer container2 = new GagetContainer("分布运算");
		container2.addLeft(addGadget);
		mainContainer.addTab(container1);
		mainContainer.addTab(container2);
		return mainContainer;
	}

	@Override
	public void save(MainContainer mainContainer) {
		PersistenceManager pm = PMF.getPersistenceManager();
		pm.makePersistent(mainContainer);
		pm.close();
	}

	@Override
	public void initMainContainer() {
		save(initFromCode());
	}

}
