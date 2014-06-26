package com.thpoiani.slidemd.repositories;

import java.util.List;

import com.thpoiani.slidemd.models.Presentation;

public interface PresentationRepository {
	/*
	 * Delete the methods you don't want to expose
	 */
	 
	void create(Presentation entity);
	
	Presentation update(Presentation entity);
	
	void destroy(Presentation entity);
	
	Presentation find(Long id);
	
	List<Presentation> findAll();

}
