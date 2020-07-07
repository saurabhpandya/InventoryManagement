package com.inventorymanagement.jwt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;

public class JwtUserNamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authManager;

	private final JwtConfig jwtConfig;

	private final SecretKey secretKey;

	public JwtUserNamePasswordAuthFilter(AuthenticationManager authManager, JwtConfig jwtConfig, SecretKey secretKey) {
		this.authManager = authManager;
		this.jwtConfig = jwtConfig;
		this.secretKey = secretKey;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			UserNamePasswordAuthRequest userNamePasswordAuthRequest = new ObjectMapper()
					.readValue(request.getInputStream(), UserNamePasswordAuthRequest.class);

			Authentication authentication = new UsernamePasswordAuthenticationToken(
					userNamePasswordAuthRequest.getUsername(), userNamePasswordAuthRequest.getPassword());

			Authentication authenticate = authManager.authenticate(authentication);

			return authenticate;

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String token = Jwts.builder().setSubject(authResult.getName()).claim("authorities", authResult.getAuthorities())
				.setIssuedAt(new Date()).setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
				.signWith(secretKey).compact();

		response.addHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + token);

	}

}
