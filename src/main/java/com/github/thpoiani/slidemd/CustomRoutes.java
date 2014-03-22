package com.github.thpoiani.slidemd;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.http.route.RoutesConfiguration;
import br.com.caelum.vraptor.http.route.Rules;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

import com.github.thpoiani.slidemd.controllers.DashboardController;
import com.github.thpoiani.slidemd.controllers.IndexController;
import com.github.thpoiani.slidemd.controllers.LoginController;
import com.github.thpoiani.slidemd.controllers.SignupController;

@Component  
@ApplicationScoped  
public class CustomRoutes implements RoutesConfiguration {  
  
    public void config(Router router) {  
        new Rules(router) {  
            public void routes() {
            	// TODO end /
            	
            	routeFor("/").withPriority(Path.HIGHEST).is(IndexController.class).index();
            	routeFor("/home").withPriority(Path.HIGHEST).is(IndexController.class).index();
            	
            	routeFor("/enter").withPriority(Path.HIGHEST).is(LoginController.class).index();
            	routeFor("/start").withPriority(Path.HIGHEST).is(SignupController.class).index();
            	
            	routeFor("/{username}").withPriority(Path.LOWEST).is(DashboardController.class).index();
            	
            	// TODO HASHBANG
//            	routeFor("/{username}/#!/{hash}").withPriority(Path.LOW).is(DashboardController.class).live();
//            	routeFor("/{username}/{hash}").withPriority(Path.LOWEST).is(DashboardController.class).preview();
            }  
        };  
    }  
}