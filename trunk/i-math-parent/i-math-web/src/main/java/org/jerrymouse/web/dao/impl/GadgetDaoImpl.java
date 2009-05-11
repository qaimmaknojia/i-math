package org.jerrymouse.web.dao.impl;

import javax.jdo.PersistenceManager;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.dao.PMF;

public class GadgetDaoImpl {

	public void save(Gadget gadget) {
		PersistenceManager pm = PMF.getPersistenceManager();
		try {
			pm.makePersistent(gadget);
		} finally {
			pm.close();
		}
	}

}
