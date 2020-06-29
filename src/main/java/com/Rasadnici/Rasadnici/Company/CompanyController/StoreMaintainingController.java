package com.Rasadnici.Rasadnici.Company.CompanyController;

import com.Rasadnici.Rasadnici.Company.Product.ProductData.Product;

public interface StoreMaintainingController {

    public void getProductList();

    public void showProductDetailPage(int id);

    public void deleteProduct(int id);

    public void addProduct(Product product);

}