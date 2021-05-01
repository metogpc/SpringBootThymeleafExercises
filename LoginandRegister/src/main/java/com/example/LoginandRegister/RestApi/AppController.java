package com.example.LoginandRegister.RestApi;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoginandRegister.Business.IUserService;
import com.example.LoginandRegister.Business.UserManager;
import com.example.LoginandRegister.Entities.User;

@RestController
@RequestMapping("/api")
public class AppController {

	private IUserService userManager;

	@Autowired
	public AppController(IUserService userManager) {
		super();
		this.userManager = userManager;
	}
	
	@GetMapping("/users")
	public List<User> get() {
		return userManager.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userManager.insert(user);	
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody User user) {
		userManager.delete(user);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody User user) {
		userManager.update(user);
	}
}
