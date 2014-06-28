package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

import com.thpoiani.slidemd.annotation.WithSession;
import com.thpoiani.slidemd.component.UserSession;
import com.thpoiani.slidemd.models.User;

@Resource
public class DashboardController {
	
	private UserSession userSession;
	
	public DashboardController(UserSession userSession) {
		this.userSession = userSession;
	}

	@WithSession
    @Get("/dashboard")
    public User index() {
		return userSession.getUser();
    }

}
