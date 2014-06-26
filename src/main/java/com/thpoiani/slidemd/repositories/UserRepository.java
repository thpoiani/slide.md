package com.thpoiani.slidemd.repositories;

import java.util.List;

import com.thpoiani.slidemd.models.User;

public interface UserRepository {
	/*
	 * Delete the methods you don't want to expose
	 */
	 
	void create(User entity);
	
	User update(User entity);
	
	void destroy(User entity);
	
	User find(Long id);
	
	List<User> findAll();

}
