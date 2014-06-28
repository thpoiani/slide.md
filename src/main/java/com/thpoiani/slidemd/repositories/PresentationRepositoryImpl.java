package com.thpoiani.slidemd.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.thpoiani.slidemd.models.Presentation;

@Component
public class PresentationRepositoryImpl
    extends Repository<Presentation, Long>
    implements PresentationRepository {

	PresentationRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Presentation find(String hash) {
		try {
            Query query = this.entityManager.createQuery("from Presentation where hash = :hash and active = :active");
            query.setParameter("hash", hash);
            query.setParameter("active", true);
            return (Presentation) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}
}
