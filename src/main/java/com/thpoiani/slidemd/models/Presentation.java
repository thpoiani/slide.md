package com.thpoiani.slidemd.models;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@javax.persistence.Entity
public class Presentation extends Entity {

	@NotNull
	@Size(min=4, max=80)
	private String title;
	
	@NotBlank
	private String context;
	
	private boolean active;
	
	private Date createdAt;
	
	@NotNull
	@javax.persistence.ManyToOne()
	@javax.persistence.JoinColumn(name="userId", nullable=false)
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
