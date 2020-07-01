package com.Rasadnici.Rasadnici.Company.CompanyController;

import com.Rasadnici.Rasadnici.Company.CompanyService.CompanyService;
import com.Rasadnici.Rasadnici.Order.OrderService.CustomerServingOrderService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Controller
@RequestMapping("/company")
public class RasadnikCustomerFacingController implements CustomerServingController {

    private CompanyService companyService;

    @Override
    @RequestMapping(path = "/customerOrderList", method = RequestMethod.GET)
    public void getCustomerOrderList() {
        CustomerServingOrderService orderService = companyService.getOrderService();
        orderService.getAllOrders();
    }

    @Override
    @RequestMapping("/approveCustomerOrder/{id}")
    public void approveCustomerOrder(@PathVariable long id) {
        CustomerServingOrderService orderService = companyService.getOrderService();
        orderService.approveCustomerOrder(id);
    }

    @Override
    @RequestMapping("/declineCustomerOrder/{id}")
    public void declineCustomerOrder(@PathVariable long id) {
        CustomerServingOrderService orderService = companyService.getOrderService();
        orderService.declineCustomerOrder(id);
    }

}