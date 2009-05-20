package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
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
	private List<Key> leftGadgetKeys = new ArrayList<Key>();

	@Persistent
	private List<Key> middleGadgetKeys = new ArrayList<Key>();

	@Persistent
	private List<Key> rightGadgetKeys = new ArrayList<Key>();

	private List<Gadget> leftGadget = new ArrayList<Gadget>();

	private List<Gadget> middleGadget = new ArrayList<Gadget>();;

	private List<Gadget> rightGadget = new ArrayList<Gadget>();;

	public GadgetContainer(String string) {
		title = string;
	}

	public void addLeft(Gadget gadget) {
		leftGadget.add(gadget);
	}

	public void addMiddle(Gadget gadget) {
		middleGadget.add(gadget);
	}
	
	public void addRight(Gadget gadget) {
		rightGadget.add(gadget);
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
		return leftGadgetKeys;
	}

	public void setLeftGadgetKeys(List<Key> leftGadgetKeys) {
		this.leftGadgetKeys = leftGadgetKeys;
	}

	public List<Key> getMiddleGadgetKeys() {
		return middleGadgetKeys;
	}

	public void setMiddleGadgetKeys(List<Key> middleGadgetKeys) {
		this.middleGadgetKeys = middleGadgetKeys;
	}

	public List<Key> getRightGadgetKeys() {
		return rightGadgetKeys;
	}

	public void setRightGadgetKeys(List<Key> rightGadgetKeys) {
		this.rightGadgetKeys = rightGadgetKeys;
	}

	public void setLeftGadget(List<Gadget> leftGadget) {
		this.leftGadget = leftGadget;
	}

	public void setMiddleGadget(List<Gadget> middleGadget) {
		this.middleGadget = middleGadget;
	}

	public void setRightGadget(List<Gadget> rightGadget) {
		this.rightGadget = rightGadget;
	}

	public List<Gadget> getLeftGadget() {
		return leftGadget;
	}

	public List<Gadget> getMiddleGadget() {
		return middleGadget;
	}

	public List<Gadget> getRightGadget() {
		return rightGadget;
	}



}