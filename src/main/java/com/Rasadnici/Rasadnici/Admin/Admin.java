package com.Rasadnici.Rasadnici.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin {

	@RequestMapping("/admin")
	public String hello() {
		return "Hello";
	}
}
