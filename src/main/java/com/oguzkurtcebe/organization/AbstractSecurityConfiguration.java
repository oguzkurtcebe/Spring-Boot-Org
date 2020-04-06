package com.oguzkurtcebe.organization;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oguzkurtcebe.organization.service.JpaUserDetailsService;

public abstract class AbstractSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService jpaUserDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(BCryptPasswordEncoder passwordEncoder,
			JpaUserDetailsService jpaUserDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(jpaUserDetailsService);
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		 auth.userDetailsService(jpaUserDetailsService).passwordEncoder(passwordEncoder);
		
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
