package com.github.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class DashboardController {
	
	public void index() {
		System.out.println("Acessou o Dashboard");
	}

	@Get
	@Path(value="/{username}/#!/{hash}", priority=Path.HIGHEST)
	public void live(String username, String hash) {
		System.out.println("Acessou live");
	}
	
	@Get
	@Path(value="/{username}/{hash}", priority=Path.LOWEST)
	public void preview(String username, String hash) {
		
		System.out.println(username + " acessou preview de " + hash);
	}

}
