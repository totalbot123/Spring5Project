package com.Rasadnici.Rasadnici.Security.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "farmer")
public class Farmer extends User {

    private String firstName;
	
    private String lastName;
    
    @Column(name="birth_date")
	private String dateOfBirth;
	
	@Column(name="birth_place")
    private String placeOfBirth;
    
    private String phoneNumber;
}
