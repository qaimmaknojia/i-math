package org.jerrymouse.web.dao.impl;

import javax.persistence.EntityManager;

import org.jerrymouse.web.bean.Gadget;
import org.jerrymouse.web.dao.PMF;

public class GadgetDaoImpl {

	public void save(Gadget gadget) {
		EntityManager pm = PMF.get().createEntityManager();
		try {
			pm.persist(gadget);
		} finally {
			pm.close();
		}
	}
	
}
