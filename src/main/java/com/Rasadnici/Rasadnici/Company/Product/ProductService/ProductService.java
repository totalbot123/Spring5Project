package com.Rasadnici.Rasadnici.Company.Product.ProductService;

import java.util.List;

import com.Rasadnici.Rasadnici.Company.Product.ProductData.Product;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public void getProduct(long id);

    public List<? extends Product> getAllProducts();

    public void addProduct(Product product);

    public void modifyProduct(Product product);

    public void deleteProduct(long id);

}