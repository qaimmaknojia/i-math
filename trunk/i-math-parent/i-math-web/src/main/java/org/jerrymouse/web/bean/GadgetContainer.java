package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.dao.MainContainerDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class GadgetContainer {
	private GadgetDao gadgetDao;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;

	@Persistent
	private String title;

	@Persistent
	private List<Key> leftGadgetKeys;

	@Persistent
	private List<Key> middleGadgetKeys;

	@Persistent
	private List<Key> rightGadgetKeys;

	public GadgetContainer(String string) {
		title = string;
	}

	public void addLeft(Gadget gadget) {
		getLeftGadgetKeys().add(gadget.getId());
	}

	public void addMiddle(Gadget gadget) {
		getMiddleGadgetKeys().add(gadget.getId());
	}

	public void addRight(Gadget gadget) {
		getRightGadgetKeys().add(gadget.getId());
	}

	public GadgetDao getGadgetDao() {
		if (gadgetDao == null) {
			gadgetDao = (GadgetDao) new ClassPathXmlApplicationContext(
					"classpath:/applicationContext.xml").getBean("gadgetDao");
		}
		return gadgetDao;
	}

	public void setGadgetDao(GadgetDao gadgetDao) {
		this.gadgetDao = gadgetDao;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Key> getLeftGadgetKeys() {
		if (leftGadgetKeys == null) {
			leftGadgetKeys = new ArrayList<Key>();
		}
		return leftGadgetKeys;
	}

	public void setLeftGadgetKeys(List<Key> leftGadgetKeys) {
		this.leftGadgetKeys = leftGadgetKeys;
	}

	public List<Key> getMiddleGadgetKeys() {
		if (middleGadgetKeys == null) {
			middleGadgetKeys = new ArrayList<Key>();
		}
		return middleGadgetKeys;
	}

	public void setMiddleGadgetKeys(List<Key> middleGadgetKeys) {
		this.middleGadgetKeys = middleGadgetKeys;
	}

	public List<Key> getRightGadgetKeys() {
		if (rightGadgetKeys == null) {
			rightGadgetKeys = new ArrayList<Key>();
		}
		return rightGadgetKeys;
	}

	public void setRightGadgetKeys(List<Key> rightGadgetKeys) {
		this.rightGadgetKeys = rightGadgetKeys;
	}

	public List<Gadget> getLeftGadget() {
		return getGadgetDao().getByKeyList(getLeftGadgetKeys());

	}

	public List<Gadget> getMiddleGadget() {
		return getGadgetDao().getByKeyList(getMiddleGadgetKeys());
	}

	public List<Gadget> getRightGadget() {
		return getGadgetDao().getByKeyList(getRightGadgetKeys());
	}

}