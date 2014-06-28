package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

import com.thpoiani.slidemd.component.UserSession;
import com.thpoiani.slidemd.models.User;

@Resource
public class ErrorController {
	
	private UserSession userSession;
	
	public ErrorController(UserSession userSession) {
		this.userSession = userSession;
	}

	@Get("/error")
	public User index() {
		return userSession.getUser();
	}
	
}
