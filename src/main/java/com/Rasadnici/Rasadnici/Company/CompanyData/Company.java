package com.Rasadnici.Rasadnici.Company.CompanyData;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.Rasadnici.Rasadnici.Company.Driver.DriverData.Driver;
import com.Rasadnici.Rasadnici.Order.OrderData.CustomerOrder;
import com.Rasadnici.Rasadnici.Security.Data.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Company extends User {

    private String abbreviation;

    private String established;

    private String location;

    @OneToMany(mappedBy = "company")
    private Set<Driver> drivers;

    @OneToOne(mappedBy = "company")
    private CustomerOrder customerOrder;
}
