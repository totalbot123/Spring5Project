package com.Rasadnici.Rasadnici.Company.CompanyService;

import com.Rasadnici.Rasadnici.Order.OrderService.OrderService;
import com.Rasadnici.Rasadnici.Product.ProductService.ProductService;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public abstract class CompanyService {

    OrderService orderService;

    ProductService productService;

}