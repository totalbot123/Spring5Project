package com.Rasadnici.Rasadnici.Security.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	@Column(name="birth_date")
	private String dateOfBirth;
	
	@Column(name="birth_place")
	private String placeOfBirth;
	
	private String email;
}
