package com.thpoiani.slidemd.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import com.thpoiani.slidemd.annotation.WithoutSession;
import com.thpoiani.slidemd.component.UserSession;
import com.thpoiani.slidemd.models.User;
import com.thpoiani.slidemd.repositories.UserRepository;

@Resource
public class UserController {

	private final Result result;
	private final UserRepository repository;
	private final Validator validator;
	private UserSession userSession;

	public UserController(Result result, UserRepository repository, 
	Validator validator, UserSession userSession) {
		this.result = result;
		this.repository = repository;
		this.validator = validator;
		this.userSession = userSession;
	}
	
	@Get("/users")
	public List<User> index() {
		return repository.findAll();
	}
	
	@WithoutSession
	@Post("/users/auth")
	public void auth(@NotEmpty @Valid User user) {
		User session = repository.find(user.getEmail(), user.getPassword());
		
		if (session != null) {
			userSession.setUser(session);
			result.redirectTo(DashboardController.class).index();
		} else {
			result.include("errors", "auth").redirectTo(EnterController.class).index();
		}
	}
	
	@Post("/users")
	public void create(@NotEmpty @Valid User user) {
		validator.validate(user);
		validator.onErrorRedirectTo(JoinController.class).index();
		repository.create(user);
		userSession.setUser(user);
		result.redirectTo(DashboardController.class).index();
	}
	
	@Get("/users/new")
	public User newUser() {
		return new User();
	}
	
	@Put("/users")
	public void update(User user) {
		validator.validate(user);
		validator.onErrorUsePageOf(this).edit(user);
		repository.update(user);
		result.redirectTo(this).index();
	}
	
	@Get("/users/{user.id}/edit")
	public User edit(User user) {
		
		return repository.find(user.getId());
	}

	@Get("/users/{user.id}")
	public User show(User user) {
		return repository.find(user.getId());
	}

	@Delete("/users/{user.id}")
	public void destroy(User user) {
		repository.destroy(repository.find(user.getId()));
		result.redirectTo(this).index();  
	}
}