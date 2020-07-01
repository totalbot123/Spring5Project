package com.Rasadnici.Rasadnici.Company.CompanyController;

import com.Rasadnici.Rasadnici.Company.Product.ProductData.Product;

public interface StoreMaintainingController {

    public void getProductList();

    public void showProductDetailPage(long id);

    public void deleteProduct(long id);

    public void addProduct(Product product);

}