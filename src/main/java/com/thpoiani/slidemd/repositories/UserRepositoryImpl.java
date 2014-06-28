package com.thpoiani.slidemd.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.thpoiani.slidemd.models.User;

@Component
public class UserRepositoryImpl
    extends Repository<User, Long>
    implements UserRepository {

	UserRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public User find(String email, String password) {
		try {
            Query query = this.entityManager.createQuery("from User where email = :email and password = :password and active = :active");
            query.setParameter("email", email);
            query.setParameter("password", password);
            query.setParameter("active", true);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
