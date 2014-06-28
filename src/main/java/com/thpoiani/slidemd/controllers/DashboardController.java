package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

import com.thpoiani.slidemd.annotation.WithSession;
import com.thpoiani.slidemd.component.UserSession;
import com.thpoiani.slidemd.models.User;
import com.thpoiani.slidemd.repositories.UserRepository;

@Resource
public class DashboardController {
	
	private UserRepository repository;
	private UserSession userSession;
	
	public DashboardController(UserRepository repository, UserSession userSession) {
		this.repository = repository;
		this.userSession = userSession;
	}

	@WithSession
    @Get("/dashboard")
    public User index() {
		return repository.find(userSession.getUser().getId());
    }

}
