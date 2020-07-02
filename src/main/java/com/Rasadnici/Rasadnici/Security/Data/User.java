package com.Rasadnici.Rasadnici.Security.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.Rasadnici.Rasadnici.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private String username;

	private String password;

	@Column(name = "confirm_password")
	private String confirmPassword;

	private String email;

	@Column(columnDefinition = "tinyint(1) default 0")
	private Boolean active;

	@Column(name = "user_type", columnDefinition = "varchar(255) default 'USER'")
	private String userType;

}
