package com.Rasadnici.Rasadnici.Security.Controller;

import com.Rasadnici.Rasadnici.Security.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView getLogin() {
		return new ModelAndView("/login.html");
	}

	@RequestMapping("/index")
	public ModelAndView getIndex() {
		userService.findUserById((long) 1);
		return new ModelAndView("/index.html");
	}

	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public ModelAndView postHomepage() {
		return new ModelAndView("/homepage.html");
	}

}
