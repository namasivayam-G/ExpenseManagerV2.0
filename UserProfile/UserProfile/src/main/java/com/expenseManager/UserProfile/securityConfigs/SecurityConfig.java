package com.expenseManager.UserProfile.securityConfigs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailService;
	
	@Bean
	public AuthenticationProvider AuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // this may not be required, depends on your app configuration
        http.authorizeRequests()
                // we need config just for console, nothing else             
                .antMatchers("/h2/**").permitAll();
        // this will ignore only h2-console csrf, spring security 4+
        http.csrf().ignoringAntMatchers("/h2/**");
        //this will allow frames with same origin which is much more safe
        http.headers().frameOptions().sameOrigin();
    }
	

}
