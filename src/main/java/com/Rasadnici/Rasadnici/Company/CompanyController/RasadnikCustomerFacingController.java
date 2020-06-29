package com.Rasadnici.Rasadnici.Company.CompanyController;

import com.Rasadnici.Rasadnici.Company.CompanyService.CompanyService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Controller
public class RasadnikCustomerFacingController implements CustomerServingController {

    private CompanyService ordeService;

    @Override
    @RequestMapping(path = "/customerOrderList", method = RequestMethod.GET)
    public void getCustomerOrderList() {

    }

    @Override
    @RequestMapping("/approveCustomerOrder/{id}")
    public void approveCustomerOrder(@PathVariable long id) {

    }

    @Override
    @RequestMapping("/declineCustomerOrder/{id}")
    public void declineCustomerOrder(@PathVariable long id) {

    }

}