package com.example.SpringBootThymeleafExample.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.SpringBootThymeleafExample.Form.LoginForm;

@Controller
public class LoginController {

	
	
	@GetMapping("/login")
	public String getLoginForm(){
		return "login";
	}
	 
	//to get login form page
	@GetMapping("/index")
	public String getindexForm() { return "index"; }
	  
	//checking for login credentials
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginForm loginform, Model model) {
		
		String username=loginform.getUsername();
		String password=loginform.getPassword();
		
		if("admin".equals(username)&& "admin".equals(password)) {
			// if username and password is correct, we are returning home page
			return "home";
		}
		//if username or password is wrong
		else
			model.addAttribute("invalidCredentials",true);
		return "login";
	}
}
