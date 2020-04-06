package com.oguzkurtcebe.organization;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Order(value=0)
@Configuration
public class InvoiceSecurityConfiguration extends AbstractSecurityConfiguration {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		http.antMatcher("/invoice/**");
	 	http.authorizeRequests().antMatchers("/invoice/**").access("hasAnyAuthority('ACCOUANTANT') or hasAnyAuthority('ADMIN')");
	 	http.csrf().disable();
	    http.httpBasic();
	}
}
