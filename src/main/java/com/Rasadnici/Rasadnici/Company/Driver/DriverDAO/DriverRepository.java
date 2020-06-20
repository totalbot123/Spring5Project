package com.Rasadnici.Rasadnici.Company.Driver.DriverDAO;

import com.Rasadnici.Rasadnici.Company.Driver.DriverData.Driver;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {

}