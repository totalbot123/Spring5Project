package com.Rasadnici.Rasadnici.Security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Rasadnici.Rasadnici.Security.Data.Company;
import com.Rasadnici.Rasadnici.Security.Data.Farmer;
import com.Rasadnici.Rasadnici.Security.Service.UserService;

@Controller
public class RegisterController {
	
	private UserService userService;
	
	public RegisterController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/registerFarmer", method = RequestMethod.GET)
	public ModelAndView getRegisterFarmer() {
		return new ModelAndView("/registerFarmer.html");
	}
	
	@RequestMapping(value = "/registerCompany", method = RequestMethod.GET)
	public ModelAndView getRegisterCompany() {
		return new ModelAndView("/registerCompany.html");
	}
	
	@RequestMapping(value = "/registerFarmer", method = RequestMethod.POST)
	public void postRegisterFarmer(@RequestParam(name = "farmer") Farmer farmer) {
		
	}
	
	@RequestMapping(value = "/registerCompany", method = RequestMethod.POST)
	public void postRegisterCompany(@RequestParam(name = "company") Company company) {

	}
}
