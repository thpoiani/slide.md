package com.thpoiani.slidemd.controllers;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import com.thpoiani.slidemd.annotation.WithSession;
import com.thpoiani.slidemd.component.UserSession;
import com.thpoiani.slidemd.models.Presentation;
import com.thpoiani.slidemd.repositories.PresentationRepository;
import com.thpoiani.slidemd.repositories.UserRepository;

@Resource
public class PresentationController {

	private final Result result;
	private final PresentationRepository repository;
	private final UserRepository userRepository;
	private final Validator validator;
	private UserSession userSession;
	
	public PresentationController(Result result, PresentationRepository repository, 
	UserRepository userRepository,	Validator validator, UserSession userSession) {
		this.result = result;
		this.repository = repository;
		this.userRepository = userRepository;	
		this.validator = validator;
		this.userSession = userSession;
	}
	
	@WithSession
    @Get("/presentation/{hash}/live")
    public Presentation live(String hash) {
		// TODO validar sessão
		// User user = userSession.getUser();
		Presentation presentation = repository.find(hash);
		
		if (presentation == null) {
			result.permanentlyRedirectTo(ErrorController.class).index();
		}
		
		return presentation;
    }

    @Get("/presentation/{hash}")
    public Presentation preview(String hash) {
		Presentation presentation = repository.find(hash);
		
		if (presentation == null) {
			result.permanentlyRedirectTo(ErrorController.class).index();
		}
		
		return presentation;
    }
	
	@Get("/presentations")
	public List<Presentation> index() {
		return repository.findAll();
	}
	
	@Post("/presentations")
	public void create(Presentation presentation) {
		validator.validate(presentation);
		validator.onErrorUsePageOf(this).newPresentation();
		repository.create(presentation);
		result.redirectTo(this).index();
	}
	
	@Get("/presentations/new")
	public Presentation newPresentation() {
		result.include("userList", userRepository.findAll());		
		return new Presentation();
	}
	
	@Put("/presentations")
	public void update(Presentation presentation) {
		validator.validate(presentation);
		validator.onErrorUsePageOf(this).edit(presentation);
		repository.update(presentation);
		result.redirectTo(this).index();
	}
	
	@Get("/presentations/{presentation.id}/edit")
	public Presentation edit(Presentation presentation) {
		result.include("userList", userRepository.findAll());		
		
		return repository.find(presentation.getId());
	}

	@Get("/presentations/{presentation.id}")
	public Presentation show(Presentation presentation) {
		return repository.find(presentation.getId());
	}

	@Delete("/presentations/{presentation.id}")
	public void destroy(Presentation presentation) {
		repository.destroy(repository.find(presentation.getId()));
		result.redirectTo(this).index();  
	}
}