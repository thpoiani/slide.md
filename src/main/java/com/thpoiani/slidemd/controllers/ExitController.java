package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class ExitController {

    @Get("/exit")
    public void index() {
        System.out.println("EXIT");
    }

}
