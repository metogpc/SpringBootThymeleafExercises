package com.example.LoginandRegister.Business;

import java.util.List;

import com.example.LoginandRegister.Entities.User;

public interface IUserService {
	List<User> getAll();
	void update(User user);
	void insert(User user);
	void delete(User user);
	User getById(int id);
}
