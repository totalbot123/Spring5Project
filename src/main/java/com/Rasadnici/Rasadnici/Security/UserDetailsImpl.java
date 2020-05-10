package com.Rasadnici.Rasadnici.Security;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Rasadnici.Rasadnici.Security.DAO.UserRepository;
import com.Rasadnici.Rasadnici.Security.Data.User;

public class UserDetailsImpl implements UserDetails {
	
	private UserRepository userRepository;
	
	private String username;
	
	public UserDetailsImpl(UserRepository userRepository, String username) {
		this.userRepository = userRepository;
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		LinkedList<GrantedAuthority> authorities =  new LinkedList<GrantedAuthority>();
		authorities.push(new SimpleGrantedAuthority("USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		User user = userRepository.findByUsername(username);
		return "{bcrypt}" + passwordEncoder().encode(user.getPassword());
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
