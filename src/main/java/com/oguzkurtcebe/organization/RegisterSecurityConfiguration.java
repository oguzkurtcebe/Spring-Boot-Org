package com.oguzkurtcebe.organization;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Order(value=2)
@Configuration
public class RegisterSecurityConfiguration extends AbstractSecurityConfiguration {
@Override
protected void configure(HttpSecurity http) throws Exception {
	http.antMatcher("/register/**");
	http.authorizeRequests().antMatchers("/register/**").anonymous();
	//http.authorizeRequests().antMatchers("/register/**").access("hasAnyAuthority('ADMIN')");
	http.csrf().disable();
    http.httpBasic();
}
}
