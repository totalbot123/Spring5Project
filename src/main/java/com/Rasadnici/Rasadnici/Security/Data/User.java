package com.Rasadnici.Rasadnici.Security.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.Rasadnici.Rasadnici.BaseEntity;

import lombok.Data;

@Data
@MappedSuperclass
public class User extends BaseEntity {

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
