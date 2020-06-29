package com.Rasadnici.Rasadnici.Company.CompanyService;

import com.Rasadnici.Rasadnici.Company.Product.ProductService.ProductService;
import com.Rasadnici.Rasadnici.Order.OrderService.CustomerServingOrderService;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public abstract class CompanyService {

    CustomerServingOrderService orderService;
    ProductService productService;

}