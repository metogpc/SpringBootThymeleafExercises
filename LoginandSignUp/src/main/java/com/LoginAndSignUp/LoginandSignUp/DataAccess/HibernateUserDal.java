package com.LoginAndSignUp.LoginandSignUp.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LoginAndSignUp.LoginandSignUp.Entities.User;

@Repository
public class HibernateUserDal implements IUserDal{

	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateUserDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	
	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		List<User> users=session.createQuery("from user").getResultList();
		return users;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.delete(user);
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		User user=session.get(User.class, id);
		return user;
	}

	
}
