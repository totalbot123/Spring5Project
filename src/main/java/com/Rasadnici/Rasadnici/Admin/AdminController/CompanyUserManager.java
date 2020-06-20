package com.Rasadnici.Rasadnici.Admin.AdminController;

import com.Rasadnici.Rasadnici.Company.CompanyData.Company;

public interface CompanyUserManager {

    public void addCompany(Company farmer);

    public void modifyCompany(Long id, Company farmer);

}