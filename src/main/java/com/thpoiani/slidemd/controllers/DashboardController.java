package com.thpoiani.slidemd.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

import com.thpoiani.slidemd.annotation.WithSession;

@Resource
public class DashboardController {

	@WithSession
    @Get("/dashboard")
    public void index() {
        System.out.println("Dashboard");
    }

	@WithSession
    @Get("/dashboard/{hash}/live")
    public void live(String hash) {
        System.out.println("LIVE: " + hash);
    }

    @Get("/dashboard/{hash}")
    public void preview(String hash) {
        System.out.println("PREVIEW: " + hash);
    }

}
