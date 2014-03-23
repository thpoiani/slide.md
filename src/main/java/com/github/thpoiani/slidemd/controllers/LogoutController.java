package com.github.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Resource;

@Resource
public class LogoutController {

	public void index() {
		System.out.println("Acessou logout");
	}
}
