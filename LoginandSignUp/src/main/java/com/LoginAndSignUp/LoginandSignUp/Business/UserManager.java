package com.LoginAndSignUp.LoginandSignUp.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.LoginAndSignUp.LoginandSignUp.DataAccess.IUserDal;
import com.LoginAndSignUp.LoginandSignUp.Entities.User;

public class UserManager implements IUserService{

	private IUserDal userDal;
	
	@Autowired
	public UserManager(IUserDal userDal) {
		super();
		this.userDal = userDal;
	}

	
	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDal.getAll();
	}


	@Override
	@Transactional
	public void update(User user) {
		// TODO Auto-generated method stub
		userDal.update(user);
	}

	@Override
	@Transactional
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDal.insert(user);
	}

	@Override
	@Transactional
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDal.delete(user);
	}

	@Override
	@Transactional
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userDal.getById(id);
	}
	
	

}
