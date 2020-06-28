package com.Rasadnici.Rasadnici.Product.ProductDAO;

import com.Rasadnici.Rasadnici.Product.ProductData.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}