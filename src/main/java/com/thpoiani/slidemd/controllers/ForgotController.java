package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class ForgotController {

	@Get("/forgot")
	public void index() {
		System.out.println("FORGOTE");
	}
}
