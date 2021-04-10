package com.FormApp.SpringBootThymelafFormApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@GetMapping("/register")
	public String showRegister(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "register";
	}
	
	@GetMapping("/register_success")
	public String showRegister_success(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "register_success";
	}
		
	
	@PostMapping("/register_success" )
	public String submitForm(@ModelAttribute("user") User user) {
		System.out.println(user);
		return "register_success";
	}
}
