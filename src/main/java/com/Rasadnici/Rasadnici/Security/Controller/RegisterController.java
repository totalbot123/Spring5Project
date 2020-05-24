package com.Rasadnici.Rasadnici.Security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Rasadnici.Rasadnici.Security.DAO.UserRepository;

@Controller
public class RegisterController {
	
	private UserRepository userRepository;
	
	public RegisterController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/registerFarmer", method = RequestMethod.GET)
	public ModelAndView getRegisterFarmer() {
		return new ModelAndView("/registerFarmer.html");
	}
	
	@RequestMapping(value = "/registerCompany", method = RequestMethod.GET)
	public ModelAndView getRegister() {
		return new ModelAndView("/registerCompany.html");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView postRegister() {
		return new ModelAndView("/register.html");
	}
}
