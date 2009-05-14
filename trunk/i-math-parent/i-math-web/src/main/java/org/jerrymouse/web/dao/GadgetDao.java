package org.jerrymouse.web.dao;

import java.util.List;

import org.jerrymouse.web.bean.Gadget;

import com.google.appengine.api.datastore.Key;

public interface GadgetDao {

	public List<Gadget> getByKeyList(List<Key> leftGadgetKey);

	public void save(Gadget smartcalculator);

	public List<Gadget> getAll();

}
