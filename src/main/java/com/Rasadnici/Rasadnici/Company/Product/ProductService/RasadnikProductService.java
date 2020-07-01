package com.Rasadnici.Rasadnici.Company.Product.ProductService;

import java.util.List;

import com.Rasadnici.Rasadnici.Company.Product.ProductDAO.ProductRepository;
import com.Rasadnici.Rasadnici.Company.Product.ProductData.Product;
import com.google.common.collect.Lists;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RasadnikProductService implements ProductService {

    private ProductRepository productRepository;

    @Override
    public void getProduct(long id) {
        productRepository.findById(id).get();
    }

    @Override
    public List<? extends Product> getAllProducts() {
        Iterable<? extends Product> iterable = productRepository.findAll();
        return Lists.newArrayList(iterable);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void modifyProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

}