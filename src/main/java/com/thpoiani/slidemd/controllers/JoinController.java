package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class JoinController {

	@Get("/join")
	public void index() {
		System.out.println("JOIN");
	}
}
