package com.thpoiani.slidemd.repositories;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import com.thpoiani.slidemd.models.Presentation;

@Component
public class PresentationRepositoryImpl
    extends Repository<Presentation, Long>
    implements PresentationRepository {

	PresentationRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
