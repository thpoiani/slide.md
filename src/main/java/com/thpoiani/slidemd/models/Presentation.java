package com.thpoiani.slidemd.models;

import java.util.Date;
@javax.persistence.Entity
public class Presentation extends Entity {

	private String title;
	private String context;
	private boolean active;
	private Date createdAt;
	
	@javax.persistence.ManyToOne()
	@javax.persistence.JoinColumn(name="userId")
	private User user;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return context;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
