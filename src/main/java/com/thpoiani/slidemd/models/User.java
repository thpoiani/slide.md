package com.thpoiani.slidemd.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@javax.persistence.Entity
public class User extends Entity {
	
	@NotNull
	@Size(min=4, max=80)
	private String name;
	
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String password;
	
	private boolean active;
	
	private Date createdAt;
	
	@javax.persistence.OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Presentation> presentations = new ArrayList<Presentation>();
	
	@PrePersist
	public void prePersist() throws Exception {
//		password = BCrypt.hashpw(password, BCrypt.gensalt(12));
		active = true;
		createdAt = new Date();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
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

	public List<Presentation> getPresentations() {
		return presentations;
	}

	public void setPresentations(List<Presentation> presentations) {
		this.presentations = presentations;
	}
	
	public void addPresentation(Presentation presentation) {
		this.presentations.add(presentation);
	}

}
