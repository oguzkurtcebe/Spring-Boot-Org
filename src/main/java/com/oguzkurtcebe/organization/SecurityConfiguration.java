package com.oguzkurtcebe.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends AbstractSecurityConfiguration {
	@Autowired
    private OidcUserService oidcUserService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/verify/**","/login.html").permitAll()	
		.anyRequest().authenticated();
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");*/
		
		http.authorizeRequests().anyRequest().authenticated()
        .and()
        .oauth2Login().userInfoEndpoint().oidcUserService(oidcUserService).and().authorizationEndpoint()
        .baseUri("/oauth2/authorize").authorizationRequestRepository(customAuthorizationRequestRepository());
		
	}

	@Bean
	public AuthorizationRequestRepository customAuthorizationRequestRepository() {
		return new HttpSessionOAuth2AuthorizationRequestRepository();
	}


}
