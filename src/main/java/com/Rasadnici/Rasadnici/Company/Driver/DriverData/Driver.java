package com.Rasadnici.Rasadnici.Company.Driver.DriverData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Rasadnici.Rasadnici.BaseEntity;
import com.Rasadnici.Rasadnici.Company.CompanyData.Company;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "driver")
public class Driver extends BaseEntity {

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

}