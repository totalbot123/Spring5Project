package com.Rasadnici.Rasadnici.Security.Controller;

import com.Rasadnici.Rasadnici.Security.Data.Farmer;
import com.Rasadnici.Rasadnici.Security.Service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterFarmerController {

    private UserService userService;

    public RegisterFarmerController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registerFarmer", method = RequestMethod.GET)
    public ModelAndView getRegisterFarmer() {
        return new ModelAndView("/registerFarmer.html", "farmer", new Farmer());
    }

    @RequestMapping(value = "/registerFarmer", method = RequestMethod.POST)
    public ModelAndView postRegisterFarmer(@ModelAttribute("farmer") Farmer farmer) {
        userService.saveUser(farmer);

        return new ModelAndView("/login.html");
    }

}