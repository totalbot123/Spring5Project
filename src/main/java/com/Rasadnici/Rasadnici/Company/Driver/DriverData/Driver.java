package com.Rasadnici.Rasadnici.Company.Driver.DriverData;

import java.time.LocalTime;

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

    public Driver(Boolean available, Company company) {
        this.available = available;
        this.company = company;
        this.waitingTime = 0;
    }

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "waiting_time")
    private long waitingTime;

}