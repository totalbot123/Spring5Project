package com.Rasadnici.Rasadnici.Company.CompanyDAO;

import com.Rasadnici.Rasadnici.Company.CompanyData.Company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}