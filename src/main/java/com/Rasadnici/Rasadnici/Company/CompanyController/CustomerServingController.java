package com.Rasadnici.Rasadnici.Company.CompanyController;

public interface CustomerServingController {

    public void getCustomerOrderList();

    public void approveCustomerOrder(long id);

    public void declineCustomerOrder(long id);

}
