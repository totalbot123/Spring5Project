package com.Rasadnici.Rasadnici.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Admin {

	@RequestMapping("/admin")
	public ModelAndView hello() {
		return new ModelAndView("login");
	}
}
