package com.thpoiani.slidemd.models;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import fm.jiecao.lib.Hashids;

@javax.persistence.Entity
public class Presentation extends Entity {

	@NotNull
	private String title;
	
	private String context;
	
	private String hash;
	
	private boolean active;
	
	private Date createdAt;
	
	@NotNull
	@javax.persistence.ManyToOne()
	@javax.persistence.JoinColumn(name="userId", nullable=false)
	private User user;

	@PrePersist
	public void prePersist() throws Exception {
		Hashids hashids = new Hashids("THIAGO HENRIQUE POIANI");
		hash = hashids.encrypt(new Date().getTime());
		active = true;
		createdAt = new Date();
	}

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

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
}
