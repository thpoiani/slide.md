package com.github.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class DashboardController {
	
	public DashboardController() {

	}
	
	public void index() {
		System.out.println("Acessou o Dashboard");
	}

	@Get("/{username}/{hash}/live")
	public void live(String username, String hash) {
		System.out.println(username + " acessou live " + hash);
	}
	
	@Get("/{username}/{hash}")
	public void preview(String username, String hash) {
		System.out.println(username + " acessou preview de " + hash);
	}

}
