package com.github.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {

	public void index() {
		System.out.println("Acessou a HOME");
	}
}
