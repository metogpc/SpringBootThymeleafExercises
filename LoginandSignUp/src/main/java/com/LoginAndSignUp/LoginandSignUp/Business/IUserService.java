package com.LoginAndSignUp.LoginandSignUp.Business;

import java.util.List;

import com.LoginAndSignUp.LoginandSignUp.Entities.User;

public interface IUserService {
	List<User> getAll();
	void update(User user);
	void insert(User user);
	void delete(User user);
	User getById(int id);
}
