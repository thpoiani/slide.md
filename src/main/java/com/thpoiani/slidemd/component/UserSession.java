package com.thpoiani.slidemd.component;

import com.thpoiani.slidemd.models.User;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UserSession {

    private User user;

    public boolean isLogged() {
        return user != null;
    }

    public void logout() {
        user = null;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}