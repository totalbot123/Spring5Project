package com.Rasadnici.Rasadnici.Config;

import com.Rasadnici.Rasadnici.Company.Driver.DriverData.Driver;
import com.Rasadnici.Rasadnici.Company.DriverScheduler.CompanyDriverScheduler;
import com.Rasadnici.Rasadnici.Company.DriverScheduler.DriverScheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public DriverScheduler<Driver> driverSchedulerBean() {
        return new CompanyDriverScheduler();
    }

}