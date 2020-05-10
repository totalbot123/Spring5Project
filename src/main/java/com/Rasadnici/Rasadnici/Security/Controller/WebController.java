package com.Rasadnici.Rasadnici.Security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping("/login")
	public ModelAndView getLogin() {
		return new ModelAndView("/login.html");
	}

	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public ModelAndView postHomepage() {
		return new ModelAndView("/homepage.html");
	}

}
