package com.Rasadnici.Rasadnici.Admin;

import com.Rasadnici.Rasadnici.Security.Data.Company;

public interface CompanyUserManager {

    public void addCompany(Company farmer);

    public void modifyCompany(Long id, Company farmer);

}