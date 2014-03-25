package com.github.thpoiani.slidemd.controllers;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class DashboardController {
	
	private HttpServletResponse response;
	private Result result;
	
	
	public DashboardController(HttpServletResponse response, Result result) {
		this.response = response;
		this.result = result;
	}
	
	public void index() {
		System.out.println("Acessou o Dashboard");
	}

	@Get("/{username}/{hash}/live")
	public void live(String username, String hash) {
		System.out.println(username + " acessou live " + hash);
	}
	
	@Post("/{username}/{hash}/live")
	public void livePost(String texto) {
		String retorno = "{success:true}";

		result.use(Results.json()).withoutRoot().from(retorno).recursive().serialize();
		response.setHeader("Content-type", "application/json");
	}
	
	@Get("/{username}/{hash}")
	public void preview(String username, String hash) {
		System.out.println(username + " acessou preview de " + hash);
	}

}
