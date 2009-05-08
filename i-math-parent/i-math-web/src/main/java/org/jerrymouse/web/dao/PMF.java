package org.jerrymouse.web.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PMF {
	private static final EntityManagerFactory pmfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	private PMF() {
	}

	public static EntityManagerFactory get() {
		return pmfInstance;
	}
}
