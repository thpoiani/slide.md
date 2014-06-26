package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class DashboardController {

    @Get("/dashboard")
    public void index() {
        System.out.println("Dashboard");
    }

    @Get("/dashboard/{hash}/live")
    public void live(String hash) {
        System.out.println("LIVE: " + hash);
    }

    @Get("/dashboard/{hash}")
    public void preview(String hash) {
        System.out.println("PREVIEW: " + hash);
    }

}
