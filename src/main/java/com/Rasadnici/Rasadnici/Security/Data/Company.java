package com.Rasadnici.Rasadnici.Security.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "company")
public class Company extends User {

    private String title;

    private String established;

    private String location;
}
