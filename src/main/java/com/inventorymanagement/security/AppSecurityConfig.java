package com.inventorymanagement.security;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.inventorymanagement.jwt.JwtConfig;
import com.inventorymanagement.jwt.JwtTokenVerifier;
import com.inventorymanagement.jwt.JwtUserNamePasswordAuthFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	private final PasswordEncoder passwordEncoder;

	private final SecretKey secretKey;
	private final JwtConfig jwtConfig;
	
	@Autowired
	public AppSecurityConfig(PasswordEncoder passwordEncoder, 
			SecretKey secretKey, 
			JwtConfig jwtConfig) {
		this.passwordEncoder = passwordEncoder;
		this.secretKey = secretKey;
		this.jwtConfig = jwtConfig;
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	} 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(new JwtUserNamePasswordAuthFilter(authenticationManager(), jwtConfig, secretKey))
		.addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUserNamePasswordAuthFilter.class)
		.authorizeRequests()
		.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
		.antMatchers("/api/**").hasRole(ApplicationUserRole.USER.name())
		.antMatchers("/management/api/**").hasRole(ApplicationUserRole.ADMIN.name())
				// Define roles and sequence matters - Delete, Post, Put, Get
//				.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//				.antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//				.antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//				.antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())
				.anyRequest()
				.authenticated();
//				.and()
//				.httpBasic(); // basic authentication
//				.formLogin() // form authentiction
//					.loginPage("/login")
//					.permitAll()
//					.defaultSuccessUrl("/courses", true) // page after successful login 
//					.passwordParameter("password")
//					.usernameParameter("username")
//				.and()
//				.rememberMe()
//					.tokenValiditySeconds((int)TimeUnit.DAYS.toDays(21))
//					.key("somethingverysecured")
//					.rememberMeParameter("remember-me")
//				.and()
//				.logout()
//					.logoutUrl("/logout")
//					.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//					.clearAuthentication(true)
//					.invalidateHttpSession(true)
//					.deleteCookies("JSESSIONID","remember-me")
//					.logoutSuccessUrl("/login");// page after successful logout
		
	}

	/*
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {

		List<UserDetails> usersList = new ArrayList<UserDetails>();

		usersList.add(User.builder().username("saurabh").password(passwordEncoder.encode("1234"))
//				.roles(ApplicationUserRole.STUDENT.name())
				.authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities()).build());
		usersList.add(User.builder().username("fidato").password(passwordEncoder.encode("1234"))
//				.roles(ApplicationUserRole.ADMIN.name())
				.authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities()).build());
		usersList.add(User.builder().username("fidato_trainee").password(passwordEncoder.encode("1234"))
//				.roles(ApplicationUserRole.ADMINTRAINEE.name())
				.authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities()).build());

		return new InMemoryUserDetailsManager(usersList);
	}
	*/

}
