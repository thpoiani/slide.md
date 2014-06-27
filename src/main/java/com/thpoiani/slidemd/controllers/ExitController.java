package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

import com.thpoiani.slidemd.annotation.WithSession;

@Resource
public class ExitController {

	@WithSession
    @Get("/exit")
    public void index() {
        System.out.println("EXIT");
    }

}
