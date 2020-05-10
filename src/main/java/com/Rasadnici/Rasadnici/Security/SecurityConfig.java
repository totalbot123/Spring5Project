package com.Rasadnici.Rasadnici.Security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	
	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				.antMatchers("/admin")
				.hasRole("ADMIN")
				.antMatchers("/user")
				.hasAnyRole("ADMIN", "USER")
				.antMatchers("/")
				.permitAll()
				.and().formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/perform_login")
				.defaultSuccessUrl("/homepage", true);
//				// .failureUrl("/login.html?error=true")
////				.failureHandler(authenticationFailureHandler())
//				.and().logout()
//				.logoutUrl("/perform_logout")
//				.deleteCookies("JSESSIONID")
////				.logoutSuccessHandler(logoutSuccessHandler());
		;
	}
	
}
