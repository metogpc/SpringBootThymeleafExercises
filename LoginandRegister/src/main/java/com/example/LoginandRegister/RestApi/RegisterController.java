package com.example.LoginandRegister.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.LoginandRegister.Business.IUserService;
import com.example.LoginandRegister.Entities.User;

@Controller
public class RegisterController {

	private IUserService userManager;

	@Autowired
	public RegisterController(IUserService userManager) {
		super();
		this.userManager = userManager;
	}
	
	
	@GetMapping("/register")
	public String getRegister() {
		return "register.html";
	}
	
	@PostMapping("/register")
	public String register(Model model,User user) {
		try {
			model.addAttribute("user",user);
			System.out.println("post register");
			System.out.println(user.toString());
			userManager.insert(user);
			return "redirect:/register";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lütfen farklı bir nickname giriniz");
			return "redirect:/register";
		}
	}
	

}
