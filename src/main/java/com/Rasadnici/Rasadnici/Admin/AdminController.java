package com.Rasadnici.Rasadnici.Admin;

import com.Rasadnici.Rasadnici.Security.Data.Company;
import com.Rasadnici.Rasadnici.Security.Data.Farmer;
import com.Rasadnici.Rasadnici.Security.Service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController implements UserApporvable, FarmerUserManager, CompanyUserManager, GeneralUserManager{

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/approveRegistration/{id}", method = RequestMethod.PUT)
    public void approveUserRegistration(@PathVariable("id") String id) {
        userService.approveUser(id);
    }

    @RequestMapping(value = "/delineRegistration/{id}", method = RequestMethod.DELETE)
    public void declineUserRegistration(@PathVariable("id") String id) {
        userService.declineUser(id);
    }

    @RequestMapping(value = "/addFarmer", method = RequestMethod.POST)
    public void addFarmer(@ModelAttribute("farmer") Farmer farmer) {
        userService.saveUser(farmer);
    }

    @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
    public void addCompany(@ModelAttribute("company") Company company) {
        userService.saveUser(company);
    }

    @RequestMapping(value = "/modifyFarmer/{id}", method = RequestMethod.PUT)
    public void modifyFarmer(@PathVariable("id") String id, @ModelAttribute("farmer") Farmer farmer) {
        userService.updateUser(id, farmer);
    }

    @RequestMapping(value = "/modifyCompany/{id}", method = RequestMethod.PUT)
    public void modifyCompany(@PathVariable("id") String id, @ModelAttribute("company") Company company) {
        userService.updateUser(id, company);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }

}
