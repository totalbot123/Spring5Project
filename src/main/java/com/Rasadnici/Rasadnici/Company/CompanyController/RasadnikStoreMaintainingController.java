package com.Rasadnici.Rasadnici.Company.CompanyController;

import com.Rasadnici.Rasadnici.Company.Product.ProductData.Product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Controller
public class RasadnikStoreMaintainingController implements StoreMaintainingController {

    @Override
    @RequestMapping(path = "/productList", method = RequestMethod.GET)
    public void getProductList() {
        // TODO Auto-generated method stub

    }

    @Override
    @RequestMapping(path = "/pdp/{id}", method = RequestMethod.GET)
    public void showProductDetailPage(@PathVariable int id) {
        // TODO Auto-generated method stub

    }

    @Override
    @RequestMapping(path = "/deleteProduct/{id}", method = RequestMethod.POST)
    public void deleteProduct(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    @RequestMapping(path = "/addProduct", method = RequestMethod.POST)
    public void addProduct(Product product) {
        // TODO Auto-generated method stub

    }

}