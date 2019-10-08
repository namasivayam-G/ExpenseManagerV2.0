package com.expenseManager.GenericExpenseManagerModule.configurations;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.expenseManager.GenericExpenseManagerModule.modals.jwtConfig;

@EnableWebSecurity //This annotation tells that this class contains configuration for security
public class SecurityTokenConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private jwtConfig jwtConf;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.exceptionHandling().authenticationEntryPoint((request, response, error)->response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
		.and()
		.addFilterAfter(null, UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests().anyRequest().authenticated();
	}
	
	
	

}
