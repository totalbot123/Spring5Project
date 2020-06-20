package com.Rasadnici.Rasadnici.Security.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	String username;

	String password;

	String confirm_password;

	String email;

	@Column(columnDefinition = "boolean default false")
	@NotNull
	Boolean active;

	public Object thenReturn(Object object) {
		return null;
	}

}
