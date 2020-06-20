package com.Rasadnici.Rasadnici.Company.Driver.DriverData;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Rasadnici.Rasadnici.BaseEntity;
import com.Rasadnici.Rasadnici.Company.CompanyData.Company;

import lombok.Data;

@Data
@Entity
public class Driver extends BaseEntity {

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

}