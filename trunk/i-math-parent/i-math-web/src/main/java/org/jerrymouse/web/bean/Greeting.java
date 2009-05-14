package org.jerrymouse.web.bean;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Greeting {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String content;

	@Persistent
	private Date date;

	@Persistent
	private List<Key> strings;

	public Greeting(String content, Date date) {
		this.content = content;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStrings(List<Key> strings) {
		this.strings = strings;
	}

	public List<Key> getStrings() {
		return strings;
	}
}
