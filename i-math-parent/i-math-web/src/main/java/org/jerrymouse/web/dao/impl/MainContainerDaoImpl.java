package org.jerrymouse.web.dao.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.bean.GadgetContainer;
import org.jerrymouse.web.bean.Greeting;
import org.jerrymouse.web.bean.MainContainer;
import org.jerrymouse.web.dao.GadgetContainerDao;
import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.dao.MainContainerDao;
import org.jerrymouse.web.dao.PMF;

import com.google.appengine.api.datastore.Key;

public class MainContainerDaoImpl extends JdoDaoSupport implements
		MainContainerDao {
	private GadgetDao gadgetDao;
	private GadgetContainerDao gadgetContainerDao;

	@Override
	public MainContainer getMainContainer() {
		init();
		List<MainContainer> list = getAll();
		return list.get(0);
	}

	public MainContainer getById(Key id) {
		MainContainer object;
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			object = pm.getObjectById(MainContainer.class, id);
			object.getTabKeys();
		} finally {
			pm.close();
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public List<MainContainer> getAll() {
		return super.getAll(MainContainer.class);
	}

	@Override
	public void save(MainContainer mainContainer) {
		super.save(mainContainer);
	}

	public void setGadgetDao(GadgetDao gadgetDao) {
		this.gadgetDao = gadgetDao;
	}

	public GadgetContainerDao getGadgetContainerDao() {
		return gadgetContainerDao;
	}

	public void setGadgetContainerDao(GadgetContainerDao gadgetContainerDao) {
		this.gadgetContainerDao = gadgetContainerDao;
	}

	public GadgetDao getGadgetDao() {
		return gadgetDao;
	}

	public MainContainer initFromCode() {
		Gadget smartcalculator = new Gadget("smartcalculator",
				"/gadgets/smartcalculator/smartcalculator.xml");

		Gadget addGadget = new Gadget("add-gadget",
				"/gadgets/add-gadget/add-gadget.xml");

		GadgetContainer container1 = new GadgetContainer("概率运算");
		GadgetContainer container2 = new GadgetContainer("分布运算");

		container1.addLeft(smartcalculator);
		container1.addLeft(addGadget);
		container2.addLeft(addGadget);

		MainContainer mainContainer = new MainContainer();

		mainContainer.addTab(container1);
		mainContainer.addTab(container2);

		return mainContainer;
	}

	@Override
	public void init() {
		PersistenceManagerFactory pmf = PMF.get();
		PersistenceManager pm = pmf.getPersistenceManager();
		MainContainer mainContainer;
		try {
			Gadget addGadget = new Gadget("add-gadget",
					"/gadgets/add-gadget/add-gadget.xml");
			System.out.println(gadgetDao.getAll());
			gadgetDao.save(addGadget);
			System.out.println(gadgetDao.getAll());
			GadgetContainer container1 = new GadgetContainer("概率运算");
			System.out.println(gadgetContainerDao.getAll());
			container1.addLeft(addGadget);

			gadgetContainerDao.save(container1);
			System.out.println(gadgetContainerDao.getAll());

			mainContainer = new MainContainer();

			mainContainer.addTab(container1);
			save(mainContainer);
		} finally {

			pm.close();

		}
	}
}
