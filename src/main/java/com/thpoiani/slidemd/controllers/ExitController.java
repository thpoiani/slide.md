package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.thpoiani.slidemd.annotation.WithSession;
import com.thpoiani.slidemd.component.UserSession;

@Resource
public class ExitController {
	
	private Result result;
	private UserSession userSession;
	
	public ExitController(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	@WithSession
    @Get("/exit")
    public void index() {
		userSession.setUser(null);
		result.redirectTo(IndexController.class).index();
    }

}
