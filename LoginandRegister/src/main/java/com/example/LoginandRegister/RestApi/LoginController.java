package com.example.LoginandRegister.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.LoginandRegister.Business.IUserService;
import com.example.LoginandRegister.Entities.User;

@Controller
public class LoginController {

	private IUserService userManager;

	@Autowired
	public LoginController(IUserService userManager) {
		super();
		this.userManager = userManager;
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(Model model,User user) {
		model.addAttribute("user",user);
		List<User> users= userManager.getAll();
		boolean a=false;
		
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getNickname().equals(user.getNickname()) && users.get(i).getPassword().equals(user.getPassword())) {
				a=true;
				break;
			}
		}
		
		if (a) {
			System.out.println("Giriş başarılı");
			return "redirect:/menu";
		}
		else {
			System.out.println("Giriş başarısız");
			return "redirect:/login";
		}

	}
	
}
