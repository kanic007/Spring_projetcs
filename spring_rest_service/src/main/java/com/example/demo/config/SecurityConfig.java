package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.inMemoryAuthentication().withUser("india").password(encoder.encode("india")).roles("ADMIN")
//		.and()
//		.withUser("nepal")
//		.password(encoder.encode("nepal")).roles("GUEST");
		
		
		auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery("select username,pass_word,enabled from kanic_user where username=?")
		  .authoritiesByUsernameQuery("select u.username,a.authority from kanic_authorits a, kanic_user u where u.username =? and u.username=a.username")
		  .passwordEncoder(encoder);
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeHttpRequests().antMatchers("/api/v2/teachers/**","/actuator/info").permitAll()
		.antMatchers("/api/v1/students/55**")
		
		
		.authenticated()
		   .and().csrf().disable()
		   .httpBasic();
		
//		http.authorizeHttpRequests().antMatchers("/api/v1/students/**").hasRole("ADMIN")
//		 .and()
//		   .httpBasic();
	}
	

//	@Bean
//	public BCryptPasswordEncoder encoder() {
//		
//		return new BCryptPasswordEncoder();
//	}
	
//	BasicAuthenticationFilter avc ;
	
}
