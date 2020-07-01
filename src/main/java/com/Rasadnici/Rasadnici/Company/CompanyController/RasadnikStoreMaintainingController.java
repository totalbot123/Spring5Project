package com.Rasadnici.Rasadnici.Company.CompanyController;

import com.Rasadnici.Rasadnici.Company.CompanyService.CompanyService;
import com.Rasadnici.Rasadnici.Company.Product.ProductData.Product;
import com.Rasadnici.Rasadnici.Company.Product.ProductService.ProductService;

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
public class RasadnikStoreMaintainingController implements StoreMaintainingController {

    private CompanyService companyService;

    @Override
    @RequestMapping(path = "/productList", method = RequestMethod.GET)
    public void getProductList() {
        ProductService productService = companyService.getProductService();
        productService.getAllProducts();
    }

    @Override
    @RequestMapping(path = "/pdp/{id}", method = RequestMethod.GET)
    public void showProductDetailPage(@PathVariable long id) {
        ProductService productService = companyService.getProductService();
        productService.getProduct(id);
    }

    @Override
    @RequestMapping(path = "/deleteProduct/{id}", method = RequestMethod.POST)
    public void deleteProduct(long id) {
        ProductService productService = companyService.getProductService();
        productService.deleteProduct(id);
    }

    @Override
    @RequestMapping(path = "/addProduct", method = RequestMethod.POST)
    public void addProduct(Product product) {
        ProductService productService = companyService.getProductService();
        productService.addProduct(product);
    }

}