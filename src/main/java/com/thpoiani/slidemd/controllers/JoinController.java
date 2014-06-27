package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

import com.thpoiani.slidemd.annotation.WithoutSession;

@Resource
public class JoinController {

	@WithoutSession
	@Get("/join")
	public void index() {
		System.out.println("JOIN");
	}
}
