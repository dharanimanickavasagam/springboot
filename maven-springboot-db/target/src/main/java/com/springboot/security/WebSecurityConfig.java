package com.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.service.SiteUserService;

// @Configuration - a bean for configuration 
// 
// @EnableWebSecurity
// Add this annotation to an @Configuration class to have the Spring Security configuration defined in any WebSecurityConfigurer 
// or more likely by extending the WebSecurityConfigurerAdapter base class and overriding individual methods: 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// override configure(HttpSecurity http)
	// http obj will be supplied by spring

	@Autowired
	private SiteUserService siteUserService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// authorizeRequests() - allows access to URL

		// antMatchers("/")- home screen
		// antMatchers("/**") - URL that has to match security rules
		// matches all URLs in sub folders

		// anyRequest().authenticated() - other requests needs authentication
		// /js/* - just the first directory within js
		//

		//@formatter:off
		http
			.authorizeRequests()
				.antMatchers(
						"/",  
						"/about", 
						"/register"
						)
				.permitAll()
				.antMatchers(
						"/js/*" ,
						"/css/*",
						"/img/*")
				.permitAll()
				.antMatchers(
						"/addstatus",
						"/deletestatus",
						"/viewstatus")
				.hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/",true)
				.permitAll()
			.and()
				.logout()
					.permitAll();
		
		//@formatter:on
	}

	//
	// Hardcoding uname and pwd for now
	//
	// AuthenticationManagerBuilder
	// Allows for easily building in memory authentication, LDAP authentication,
	// JDBC based authentication, adding UserDetailsService, and adding
	// AuthenticationProvider's.
	//

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		//@formatter:off
			auth
				.inMemoryAuthentication()
				.withUser("d")
				.password("d")
				.roles("ADMIN");
			
		//@formatter:on
	}

	// userDetailsService
	// Add authentication based upon the custom UserDetailsService that is
	// passed in.
	// It then returns a DaoAuthenticationConfigurer to allow customization of
	// the authentication.
	//

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.userDetailsService(siteUserService).passwordEncoder(
				passwordEncoder);

	}

}
