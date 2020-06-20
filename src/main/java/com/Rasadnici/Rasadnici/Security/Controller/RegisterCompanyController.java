package com.Rasadnici.Rasadnici.Security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Rasadnici.Rasadnici.Company.CompanyData.Company;
import com.Rasadnici.Rasadnici.Security.Service.UserService;

@Controller
public class RegisterCompanyController {

    private UserService userService;

    public RegisterCompanyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registerCompany", method = RequestMethod.GET)
    public ModelAndView getregisterCompany() {
        return new ModelAndView("/registerCompany.html", "company", new Company());
    }

    @RequestMapping(value = "/registerCompany", method = RequestMethod.POST)
    public ModelAndView postregisterCompany(@ModelAttribute("company") Company company) {
        userService.saveUser(company);

        return new ModelAndView("/login.html");
    }
}
