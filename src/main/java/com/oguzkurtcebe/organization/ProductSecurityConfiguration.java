package com.oguzkurtcebe.organization;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Order(value=1)
@Configuration
public class ProductSecurityConfiguration extends AbstractSecurityConfiguration {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
	 	
	 	
	 	http.antMatcher("/restProduct/**");
	 	http.authorizeRequests().antMatchers("/restProduct/**").access("hasAnyAuthority('PRODUCT_MANAGER') or hasAnyAuthority('ADMIN')");
	 	http.csrf().disable();
	 	http.httpBasic();
	}

}
