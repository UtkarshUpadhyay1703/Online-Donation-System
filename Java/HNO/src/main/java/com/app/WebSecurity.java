package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.app.security.JwtAuthanticationFilter;
//import com.app.security.JwtAuthenticationEntryPoint;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	@Autowired
//	private JwtAuthanticationFilter jwtAuthanticationFilter;
	

	
@Override
protected void configure(HttpSecurity http) throws Exception {
	http.cors().and().csrf().disable();
//	http
//	.csrf()
//	.disable()
//	.authorizeHttpRequests()
//	.anyRequest()
//	.authenticated()
//	.and()
//	.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//	.and()
//	.sessionManagement()
//	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	
//	http.addFilterBefore(this.jwtAuthanticationFilter, UsernamePasswordAuthenticationFilter.class);
}
//protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//	auth.userDetailsService(this.custom)
//}

//@Bean
//@Override
//public AuthenticationManager authenticationManagerBean() throws Exception{
//	return super.authenticationManagerBean();
//}


}
















